package com.horbac.xacml.services;

import com.horbac.xacml.repositories.TraitementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraitementService {
    private final TraitementRepo traitementRepo;

    @Autowired
    public TraitementService(TraitementRepo traitementRepo) {
        this.traitementRepo = traitementRepo;
    }
}
