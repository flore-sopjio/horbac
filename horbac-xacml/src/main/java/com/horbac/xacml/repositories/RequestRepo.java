package com.horbac.xacml.repositories;

import com.horbac.xacml.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request,Long> {
}
