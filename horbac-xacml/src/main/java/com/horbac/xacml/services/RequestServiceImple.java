package com.horbac.xacml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import com.horbac.xacml.model.Request;
import com.horbac.xacml.services.RequestService;
import com.horbac.xacml.repositories.RequestRepo;

@Service
public class RequestServiceImple implements RequestService {
        // attributes

        @Autowired
        private RequestRepo requestRepository;
    
        // methods
    
        /**
         * get the requests list
         *
         * @return
         */
        @Override
        public List<Request> getRequests(int pageNumber, int pageSize) {
            Pageable pages = PageRequest.of(pageNumber, pageSize);
            return requestRepository.findAll(pages).getContent();
        }
    
        /**
         * Save request to database.
         *
         * @param request
         * @return
         */
        @Override
        public Request saveRequest(Request request) { return requestRepository.save(request); }
    
        /**
         * Find and request and get it if exists
         *
         * @param id
         * @return
         */
        @Override
        public Request getSingleRequest(Long id) {
            Optional<Request> request = requestRepository.findById(id);
    
            if(request.isPresent()) return request.get();
            throw new RuntimeException("Request is not found for id = "+id);
        }
    
        /**
         * Delete an request from db.
         *
         * @param id
         */
        @Override
        public void deleteRequest(Long id) {
            requestRepository.deleteById(id);
        }
    
        /**
         * Update an request details from db
         *
         * @param request
         * @return
         */
        @Override
        public Request updateRequest(Request request) {
            return requestRepository.save(request);
        }
}
