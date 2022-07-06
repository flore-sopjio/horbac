package com.horbac.xacml.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "superieur_hierarchique")
@NoArgsConstructor
@AllArgsConstructor
public class SuperieurHierarchique implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private  Long superieurHierarchiqueId;
    private String nom;

    @Column(unique = true,nullable = false)
    private String organisationalUnit;
    /*@OneToMany(mappedBy = "superieurH", cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
    private List<SuperieurHierarchique> Superieurlist = new ArrayList<>();*/
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private SuperieurHierarchique superieurH;

    public String getOrganisationalUnit(){
        return this.organisationalUnit;
    }

}
