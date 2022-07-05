package com.horbac.xacml.pep;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.horbac.xacml.model.UniteOrganisationnelle;
import com.horbac.xacml.repositories.UniteOrganisationnelleRepo;
import com.horbac.xacml.services.UniteOrganisationnelleService;

@RestController
public class UniteOrganisationnelleController {

    // attributes

    @Autowired
    private UniteOrganisationnelleService uniteOrganisationnelleService;

    //methods

    @PostMapping("/unite_org")
    public ResponseEntity<UniteOrganisationnelle>  createUniteOrganisationnelle(@Valid @RequestBody UniteOrganisationnelle unitOrg){
        return new ResponseEntity<UniteOrganisationnelle>(uniteOrganisationnelleService.saveUniteOrganisationnelle(unitOrg), HttpStatus.CREATED);
    }
    
}
