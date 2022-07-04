package com.horbac.xacml.services;

import com.horbac.xacml.model.SuperieurHierarchique;
import com.horbac.xacml.repositories.HierarchicalSupervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HierarchicalSupervisorService {

    private final HierarchicalSupervisor hierarchicalSupervisor;

    @Autowired
    public HierarchicalSupervisorService(HierarchicalSupervisor hierarchicalSupervisor) {
        this.hierarchicalSupervisor = hierarchicalSupervisor;
    }

    public List<String> findAllSupervisorName() {
        List<String> organizationalUnit = new ArrayList<String>();
        List<SuperieurHierarchique> hierarchicalSupervisors = new ArrayList<SuperieurHierarchique>();
        hierarchicalSupervisors = this.hierarchicalSupervisor.findAll();

        hierarchicalSupervisors.forEach(superieurHierarchique ->
                organizationalUnit.add(superieurHierarchique.getOrganisationalUnit())
        );
        return organizationalUnit;
    }

    public List<SuperieurHierarchique> findAllSupervisor() {
        List<SuperieurHierarchique> listOrganizationalUnit = new ArrayList<SuperieurHierarchique>();
        listOrganizationalUnit = this.hierarchicalSupervisor.findAll();
        return  listOrganizationalUnit;
    }

    public SuperieurHierarchique saveSupervisor(SuperieurHierarchique superieurHierarchique) {
        return hierarchicalSupervisor.save(superieurHierarchique);
    }
}
