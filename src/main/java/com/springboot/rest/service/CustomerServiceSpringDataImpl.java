package com.springboot.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.springboot.rest.CustomerRest;
import com.springboot.rest.data.CustomerData;
import com.springboot.rest.entity.CustomerEntity;
import com.springboot.rest.exception.InvalidDataException;
import com.springboot.rest.exception.NoRecordFoundException;
import com.springboot.rest.repo.CustomerRepo;


@Service("csSpringDataImpl")
@Transactional
public class CustomerServiceSpringDataImpl implements CustomerService {
	/*@PersistenceContext
 private EntityManager em;*/
	private static Logger logger=LoggerFactory.getLogger(CustomerRest.class.getName());
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private CustomerMapper mapper;
	@Override
	public CustomerData createCustomer(CustomerData customer) {
		logger.debug("Entering CustomerServiceSpringDataImpl.createCustomer");
		logger.debug("Cusomer Daa Inside Service={}", customer);
		if (customer == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			throw new InvalidDataException("Invalid data to persist");
		}
		final CustomerEntity entity=mapper.mapToCustomerEntity(customer);
		logger.debug("start serving customer");
		repo.save(entity);
		customer.setId(entity.getPk());
		logger.debug("Cusomer saved sucess, Customer ID={}", entity.getPk());
		logger.debug("Exiting CustomerServiceSpringDataImpl.createCustomer");
		return customer;
	}

	@Override
	public CustomerData modifyCustomer(CustomerData customer) {//this is created as a void by the teacher
		
		CustomerEntity entity=repo.findOne(customer.getId());
		entity=mapper.mapToCustomerEntity(entity,customer);
		repo.save(entity);
		
		return customer;
	}

	@Override
	public CustomerData findCustomer(Long id) {
		final CustomerEntity entity=repo.findOne(id);
		if(entity==null) {
			throw new NoRecordFoundException("The customer with id="+id+"is not found ");
		}
		final CustomerData result=mapper.mapToCustomerData(entity);
		return result;
	}

	@Override
	public List<CustomerData> searchCustomer(String name) {
		final String searchStr=name+"%";
		List<CustomerEntity> entities=repo.searchCustomer(searchStr, searchStr);
		return mapper.mapToCustomerDataList(entities);
	}

	@Override
	public void removeCustomer(Long id) {
		final CustomerEntity entity=repo.findOne(id);
		repo.delete(entity);;

	}

}
