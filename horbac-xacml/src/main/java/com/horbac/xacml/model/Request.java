package com.horbac.xacml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Entity
@Table(name = "requests")
@NoArgsConstructor
@AllArgsConstructor
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private  Long requestId;

	@Column(name = "subject_id", nullable = false, updatable = true)
    @NotBlank(message = "The field subject id can't be null")
	private String subjectId;

	@Column(name = "organizational_unit", nullable = false, updatable = true)
    @NotBlank(message = "The field organizationalUnit id can't be null")
	private String organizationalUnit;

	@Column(name = "resource_id", nullable = false, updatable = true)
    @NotBlank(message = "The field resourceId id can't be null")
	private String resourceId;

	@Column(name = "view", nullable = false, updatable = true)
    @NotBlank(message = "The field view id can't be null")
	private String view;

	@Column(name = "action_id", nullable = false, updatable = true)
    @NotBlank(message = "The field actionId id can't be null")
	private String actionId;

	@Column(name = "environment_id", nullable = false, updatable = true)
    @NotBlank(message = "The field environmentId id can't be null")
	private String environmentId;

	@Column(name = "status", nullable = true, updatable = true)
    @NotBlank(message = "The field status id can't be null")
	private String status;

	/*
	 * Le constructeur de recopie
	 * @param request
	 */
	public Request(
		String actionId, 
		String environmentId, 
		String organizationalUnit, 
		String resourceId, 
		String status, 
		String view,
		String subjectId){

		this.subjectId = subjectId;
		this.organizationalUnit = organizationalUnit;
		this.resourceId = resourceId;
		this.view = view;
		this.actionId = actionId;
		this.environmentId = environmentId;
		this.status = status;
	}
}
