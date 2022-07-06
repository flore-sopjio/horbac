package com.horbac.xacml.pep;

import java.rmi.ServerException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import com.horbac.xacml.model.Request;
import com.horbac.xacml.services.PDPEngineService;
import com.horbac.xacml.services.RequestService;

import oasis.names.tc.xacml._3_0.core.schema.wd_17.DecisionType;

@RestController
public class PEPController {
	@Autowired
	protected PDPEngineService pdpService;
    @Autowired
	protected RequestService requestService;

	/* 
	@GetMapping("/")
	public DecisionType checkRequest(@RequestParam String subjectId, @RequestParam String resourceId,
			@RequestParam String actionId) {
		Request req = new Request(subjectId, resourceId, actionId);
		return pdpService.evaluate(req);
	}
	*/

	@PostMapping("/request/req")
	public ResponseEntity<DecisionType> checkRequest(@RequestBody Request request) {
		Request req = request;
		
		return new ResponseEntity<>(pdpService.evaluate(req), HttpStatus.OK) ;
	}

	/**
	 * 
	 *================================================================================
	 *        					Methodes sur les requests
	 *================================================================================
	 * 
	 */


    /**
     * Get the requests list
     * @return
     * @return
     */
    @GetMapping("/request")
    public ResponseEntity<List<Request>> getRequests(@RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<List<Request>>(requestService.getRequests(page, size), HttpStatus.OK);
    }

    /**
     * Get single request
     * @return
     */
    @GetMapping("/request/{id}")
    public ResponseEntity<Request> getRequest(@PathVariable Long id){

        return new ResponseEntity<Request>(requestService.getSingleRequest(id), HttpStatus.OK);
    }

    /**
     * create an request
     * @param request
     * @return
     */
    @PostMapping("/request")
    public ResponseEntity<Request> createRequest(@Valid @RequestBody Request requestModel){

        // get the data passed by request/passed to postman
        Request request = new Request(
                                   requestModel.getActionId(),
                                   requestModel.getEnvironmentId(),
                                   requestModel.getOrganizationalUnit(),
                                   requestModel.getResourceId(),
                                   requestModel.getStatus(),
                                   requestModel.getView(),
                                   requestModel.getSubjectId()
                                  );

        System.out.println(request);

        return new ResponseEntity<Request>(requestService.saveRequest(request), HttpStatus.CREATED);
    }

    /**
     * update an request
     * @param id
     * @param request
     * @return
     */
    @PutMapping("/request/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable Long id, @RequestBody Request request){
    //    request.setRequestId(id);
       return new ResponseEntity<Request>(requestService.updateRequest(request), HttpStatus.OK);
    }

    /**
     * delete an Request
     * @param id
     * @return
     */
    @DeleteMapping("/request")
    public ResponseEntity<HttpStatus> deleteRequest(@RequestParam Long id){

//        requestService.deleteRequest(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

    }


}