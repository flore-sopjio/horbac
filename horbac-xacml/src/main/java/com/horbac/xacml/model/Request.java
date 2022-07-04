package com.horbac.xacml.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private  Long requestId;
	private String subjectId;
	private String organizationalUnit;
	private String resourceId;
	private String view;
	private String actionId;
	private String environmentId;
	private String status;

	/* public String getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(String environmentId) {
		this.environmentId = environmentId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getOrganizationalUnit() {
		return organizationalUnit;
	}

	public void setOrganizationalUnit(String organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
 */
	public Request(String subjectId, String resourceId, String actionId) {
		this.subjectId = subjectId;
		this.resourceId = resourceId;
		this.actionId = actionId;
	}

	public Request(String subjectId, String organizationalUnit, String resourceId, String view, String actionId, String environmentId) {
		this.subjectId = subjectId;
		this.organizationalUnit = organizationalUnit;
		this.resourceId = resourceId;
		this.view = view;
		this.actionId = actionId;
		this.environmentId = environmentId;
	}

	public Request() {
	}
}
