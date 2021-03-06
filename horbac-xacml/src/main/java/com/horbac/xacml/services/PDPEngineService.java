package com.horbac.xacml.services;

import java.io.IOException;
import java.util.Optional;

import org.ow2.authzforce.core.pdp.api.AttributeFqn;
import org.ow2.authzforce.core.pdp.api.AttributeFqns;
import org.ow2.authzforce.core.pdp.api.DecisionRequest;
import org.ow2.authzforce.core.pdp.api.DecisionRequestBuilder;
import org.ow2.authzforce.core.pdp.api.DecisionResult;
import org.ow2.authzforce.core.pdp.api.value.AnyUriValue;
import org.ow2.authzforce.core.pdp.api.value.AttributeBag;
import org.ow2.authzforce.core.pdp.api.value.Bags;
import org.ow2.authzforce.core.pdp.api.value.StandardDatatypes;
import org.ow2.authzforce.core.pdp.api.value.StringValue;
import org.ow2.authzforce.core.pdp.impl.BasePdpEngine;
import org.ow2.authzforce.core.pdp.impl.PdpEngineConfiguration;
import org.ow2.authzforce.xacml.identifiers.XacmlAttributeCategory;
import org.ow2.authzforce.xacml.identifiers.XacmlAttributeId;
import org.springframework.stereotype.Service;

import com.horbac.xacml.model.AttributesXacmlId;
import com.horbac.xacml.model.Request;

import oasis.names.tc.xacml._3_0.core.schema.wd_17.Attribute;
import oasis.names.tc.xacml._3_0.core.schema.wd_17.DecisionType;

@Service
public class PDPEngineService {

	public DecisionType evaluate(Request req) {
		try {
			final PdpEngineConfiguration pdpEngineConf = PdpEngineConfiguration
					.getInstance("src/main/resources/policy/pdp.xml");

			/*
			 * Create the PDP engine. You can reuse the same for all requests, so do it only
			 * once for all.
			 */
			final BasePdpEngine pdp = new BasePdpEngine(pdpEngineConf);

			// Create the XACML request in native model
			final DecisionRequestBuilder<?> requestBuilder = pdp.newRequestBuilder(-1, -1);
			/*
			 * If you care about memory optimization (avoid useless memory allocation), make
			 * sure you know the (expected) number of XACML attribute categories and
			 * (expected) total number of attributes in the request, and use these as
			 * arguments to newRequestBuilder(int,int) method, instead of negative values
			 * like above. e.g. 3 attribute categories, 4 total attributes in this case
			 */
			// final DecisionRequestBuilder<?> requestBuilder = pdp.newRequestBuilder(3, 4);

			// Add subject ID attribute (access-subject category), no issuer, string value
			// "john"
			final AttributeFqn subjectIdAttributeId = AttributeFqns
					.newInstance(XacmlAttributeCategory.XACML_1_0_ACCESS_SUBJECT.value(), Optional.empty(),
							AttributesXacmlId.SUBJECT_ID.value());
			final AttributeBag<?> subjectIdAttributeValues = Bags.singletonAttributeBag(StandardDatatypes.STRING,
					new StringValue(req.getSubjectId()));
			requestBuilder.putNamedAttributeIfAbsent(subjectIdAttributeId, subjectIdAttributeValues);

			final AttributeFqn subjectAttributeOrg = AttributeFqns.newInstance(
					XacmlAttributeCategory.XACML_1_0_ACCESS_SUBJECT.value(), Optional.empty(),
					AttributesXacmlId.SUBJECT_ORGANIZATIONAL_UNIT.value());
			final AttributeBag<?> subjectAttributeOrgValues = Bags.singletonAttributeBag(StandardDatatypes.STRING,
					new StringValue(req.getOrganizationalUnit()));
			requestBuilder.putNamedAttributeIfAbsent(subjectAttributeOrg, subjectAttributeOrgValues);
			// Add resource ID attribute (resource category), no issuer, string value
			// "/some/resource/location"
			final AttributeFqn resourceIdAttributeId = AttributeFqns.newInstance(
					XacmlAttributeCategory.XACML_3_0_RESOURCE.value(), Optional.empty(),
					AttributesXacmlId.RESOURCE_ID.value());
			final AttributeBag<?> resourceIdAttributeValues = Bags.singletonAttributeBag(StandardDatatypes.STRING,
					new StringValue(req.getResourceId()));
			requestBuilder.putNamedAttributeIfAbsent(resourceIdAttributeId, resourceIdAttributeValues);

			final AttributeFqn resourceAttributeView = AttributeFqns.newInstance(
					XacmlAttributeCategory.XACML_3_0_RESOURCE.value(),
					Optional.empty(), AttributesXacmlId.RESOURCE_VIEW.value());
			final AttributeBag<?> resourceViewAttributValue = Bags.singletonAttributeBag(StandardDatatypes.STRING,
					new StringValue(req.getView()));
			requestBuilder.putNamedAttributeIfAbsent(resourceAttributeView, resourceViewAttributValue);
			// Add action ID attribute (action category), no issuer, string value "GET"
			final AttributeFqn actionIdAttributeId = AttributeFqns.newInstance(
					XacmlAttributeCategory.XACML_3_0_ACTION.value(), Optional.empty(),
					AttributesXacmlId.ACTION_ID.value());
			final AttributeBag<?> actionIdAttributeValues = Bags.singletonAttributeBag(StandardDatatypes.STRING,
					new StringValue(req.getActionId()));
			requestBuilder.putNamedAttributeIfAbsent(actionIdAttributeId, actionIdAttributeValues);

			final AttributeFqn environmentCurrentTime = AttributeFqns.newInstance(
					XacmlAttributeCategory.XACML_3_0_ENVIRONMENT.value(), Optional.empty(),
					AttributesXacmlId.ENVIRONMENT_ID.value());
			final AttributeBag<?> environmentCurrentTimeValue = Bags.singletonAttributeBag(StandardDatatypes.STRING,
					new StringValue(req.getEnvironmentId()));
			requestBuilder.putNamedAttributeIfAbsent(environmentCurrentTime, environmentCurrentTimeValue);

			// No more attribute, let's finalize the request creation
			final DecisionRequest request = requestBuilder.build(false);
			// Evaluate the request
			final DecisionResult result = pdp.evaluate(request);
			result.getPepActions();
			if (result.getDecision() == DecisionType.PERMIT) {
				return result.getDecision();
			} else {
				// Not a Permit :-( (maybe Deny, NotApplicable or Indeterminate)
				return result.getDecision();
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DecisionType.DENY;
	}

}
