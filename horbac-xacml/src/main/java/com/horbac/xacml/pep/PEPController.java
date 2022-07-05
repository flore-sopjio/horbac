package com.horbac.xacml.pep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horbac.xacml.model.Request;
import com.horbac.xacml.services.PDPEngineService;

import oasis.names.tc.xacml._3_0.core.schema.wd_17.DecisionType;

@RestController
@RequestMapping("/request")
public class PEPController {
	@Autowired
	protected PDPEngineService pdpService;

	/* 
	@GetMapping("/")
	public DecisionType checkRequest(@RequestParam String subjectId, @RequestParam String resourceId,
			@RequestParam String actionId) {
		Request req = new Request(subjectId, resourceId, actionId);
		return pdpService.evaluate(req);
	}
	*/

	@PostMapping("/req")
	public ResponseEntity<DecisionType> checkRequest(@RequestBody Request request) {
		Request req = request;
		
		return new ResponseEntity<>(pdpService.evaluate(req), HttpStatus.OK) ;
	}


}