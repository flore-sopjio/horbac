package com.horbac.xacml.model;

public enum AttributesXacmlId {
    
    /* subject Attributes */

    SUBJECT_ID("subjectId"),

    SUBJECT_ORGANIZATIONAL_UNIT("organizationalUnit"),

    /*resource Attributes */

    RESOURCE_ID("resourceId"),

    RESOURCE_VIEW ("view"),

    /*Action attributes */

    ACTION_ID("actionId"),

    /*Environment */

   ENVIRONMENT_ID("environmentId");

   /**
 *
 */
private final String value;

   AttributesXacmlId(final String v)
	{
		value = v;
	}

	/**
	 * Get attribute ID (URI)
	 * 
	 * @return attribute ID
	 */
	public String value()
	{
		return value;
	}
}
