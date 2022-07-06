package com.horbac.xacml.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horbac.xacml.model.UniteOrganisationnelle;
import com.horbac.xacml.repositories.UniteOrganisationnelleRepo;

@Service
public class UniteOrganisationnelleServiceImple implements  UniteOrganisationnelleService{

     // attributes

     @Autowired
     private UniteOrganisationnelleRepo uniteOrganisationnelleRepo;
 
     // methods

     /**
     * Save unitOrg to database.
     *
     * @param unitOrg
     * @return
     */
    @Override
    public UniteOrganisationnelle saveUniteOrganisationnelle(UniteOrganisationnelle unitOrg) { return uniteOrganisationnelleRepo.save(unitOrg); }
    
}
