package com.horbac.xacml.pep;

import com.horbac.xacml.services.TraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/traitement")
public class TraitementController {
    private final TraitementService traitementService;


    public TraitementController(TraitementService traitementService) {
        this.traitementService = traitementService;
    }
}
