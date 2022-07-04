package com.horbac.xacml.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long traitementId;
    private String décision;
    private String environnement;
    private Timestamp tempsTraitement;
    @ManyToOne
    private Request requete;
    @ManyToOne
    private SuperieurHierarchique superieur;

}
