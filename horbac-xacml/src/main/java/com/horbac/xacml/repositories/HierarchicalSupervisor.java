package com.horbac.xacml.repositories;

import com.horbac.xacml.model.SuperieurHierarchique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HierarchicalSupervisor extends JpaRepository<SuperieurHierarchique, Long> {
    @Override
    Optional<SuperieurHierarchique> findById(Long id);
}
