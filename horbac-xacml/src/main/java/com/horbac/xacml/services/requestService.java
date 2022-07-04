package com.horbac.xacml.services;

import com.horbac.xacml.repositories.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class requestService {

    private  final RequestRepo requestRepo;

    @Autowired
    public requestService(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }
}
