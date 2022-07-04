package com.horbac.xacml.pep;

import com.horbac.xacml.model.SuperieurHierarchique;
import com.horbac.xacml.services.HierarchicalSupervisorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    private  final HierarchicalSupervisorService hierarchicalSupervisorService;


    public SupervisorController(HierarchicalSupervisorService hierarchicalSupervisorService) {
        this.hierarchicalSupervisorService = hierarchicalSupervisorService;
    }

    @PostMapping("/new")
    public ResponseEntity<SuperieurHierarchique> createSupervisor(@RequestBody SuperieurHierarchique superieurHierarchique){
        SuperieurHierarchique newSupervisor = hierarchicalSupervisorService.saveSupervisor(superieurHierarchique);
        return new ResponseEntity<>(newSupervisor, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<List<String>> getAllSupervisor(){
        List<String> organizationalUnit = new ArrayList<String>();
        organizationalUnit = hierarchicalSupervisorService.findAllSupervisorName();
        return new ResponseEntity<>(organizationalUnit, HttpStatus.OK);
    }

    @GetMapping("/allSupervisor")
    @ModelAttribute("supervisor")
    public ResponseEntity<List<SuperieurHierarchique>>  getSupervisorList() {
        List<SuperieurHierarchique> supervisorList =new ArrayList<SuperieurHierarchique>();
        supervisorList = hierarchicalSupervisorService.findAllSupervisor();
        return new ResponseEntity<>(supervisorList, HttpStatus.OK);
    }

    @GetMapping("/allUnity")
    @ModelAttribute("OrgUnity")
    public ResponseEntity<List<String >>  getUnityList() {
        List<String> supervisorList =new ArrayList<String>();
        supervisorList.add("Direction générale");
        supervisorList.add("Direction des ressources humaines");
        supervisorList.add("Direction du service technique");
        supervisorList.add("Conseil des employers");
        supervisorList.add("Direction Marketing");
        supervisorList.add("Direction des ventes");
        supervisorList.add("Direction des finances");
        supervisorList.add("Direction de la production");
        supervisorList.add("Direction économique");
        return new ResponseEntity<>(supervisorList, HttpStatus.OK);
    }
}
