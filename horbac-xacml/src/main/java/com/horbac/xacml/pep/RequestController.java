package com.horbac.xacml.pep;

import com.horbac.xacml.services.requestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request1")
public class RequestController {
    private final requestService requestService;

    public RequestController(com.horbac.xacml.services.requestService requestService) {
        this.requestService = requestService;
    }
}
