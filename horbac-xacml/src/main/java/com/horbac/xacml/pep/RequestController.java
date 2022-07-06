package com.horbac.xacml.pep;

import com.horbac.xacml.services.RequestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request1")
public class RequestController {
    private final RequestService requestService;

    public RequestController(com.horbac.xacml.services.RequestService requestService) {
        this.requestService = requestService;
    }

}
