package com.horbac.xacml.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.horbac.xacml.model.UniteOrganisationnelle;

@Repository
public interface UniteOrganisationnelleRepo extends PagingAndSortingRepository<UniteOrganisationnelle, Long> {
    
}
