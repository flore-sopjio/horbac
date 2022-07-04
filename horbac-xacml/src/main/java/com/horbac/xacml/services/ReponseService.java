package com.horbac.xacml.services;

import com.horbac.xacml.repositories.ReponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReponseService {
    private final ReponseRepo reponseRepo;

    @Autowired
    public ReponseService(ReponseRepo reponseRepo) {
        this.reponseRepo = reponseRepo;
    }
}
