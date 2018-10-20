package com.springboot.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.rest.entity.CustomerEntity;
//this used as entityManager
public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {
	@Query("select c from CustomerEntity c where UPPER(c.firstName) like UPPER(?1) OR UPPER(c.lastName) like UPPER(?2) ")
List<CustomerEntity> searchCustomer(final String firstName, final String lastName);
}
 