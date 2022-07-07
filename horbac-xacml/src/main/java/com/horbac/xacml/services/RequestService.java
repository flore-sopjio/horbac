package com.horbac.xacml.services;

import com.horbac.xacml.model.Request;

import java.util.List;

/**
 * Cette interface comprends toutes les methodes a implenmenter sur un service 
 */
public interface RequestService {

    /**
     * get the requests list with pagination
     * @return
     */
    List<Request> getRequestsPagenate(int pageNumber, int pageSize);

    /**
     * get the requests list without pagination
     * @return
     */
    List<Request> getRequests();

    /**
     * Save request to database.
     * @param requests
     * @return
     */
    Request saveRequest(Request request);

    /**
     * Find and request and get it if exists
     * @param id
     * @return
     */
    Request getSingleRequest(Long id);

    /**
     * Delete an request from db.
     * @param id
     */
    void deleteRequest(Long id);

    /**
     *Update an request details from db
     * @param request
     * @return
     */
    Request updateRequest(Request request);
}
