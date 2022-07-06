package com.horbac.xacml.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "unite_org")
@NoArgsConstructor
@AllArgsConstructor
public class UniteOrganisationnelle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, updatable = true)
    @NotBlank(message = "The field name can't be null")
    private String name;

    @JoinColumn(name = "unite_org_sup_id", nullable = true)
    @ManyToOne
    private UniteOrganisationnelle uniteOrg;
    
}
