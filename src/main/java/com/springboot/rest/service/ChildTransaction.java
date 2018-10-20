package com.springboot.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.entity.CustomerEntity;
import com.springboot.rest.repo.CustomerRepo;

@Service("ctTransaction")
//@Transactional(propagation=Propagation.SUPPORTS)
public class ChildTransaction implements CustomerTransaction {
	@Autowired
	private CustomerRepo repo;

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void createCustomer() {
		save("Child", "Transaction");
		throw new RuntimeException("Roll Back");
	}

	private void save(final String fristName, final String lastName) {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName(fristName);
		entity.setLastName(lastName);
		repo.save(entity);
	}

}
