package com.springboot.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.entity.CustomerEntity;
import com.springboot.rest.entity.QueryConstant;
import com.springboot.rest.exception.InvalidDataException;
import com.springboot.rest.exception.NoRecordFoundException;


@Service("csJpaImpl")
@Transactional
public class CustomerServiceJpaImpl implements CustomerService {
	@PersistenceContext
 private EntityManager em;
	
	@Autowired
	private CustomerMapper mapper;
	@Override
	public CustomerData createCustomer(CustomerData customer) {
		if (customer == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			throw new InvalidDataException("Invalid data to persist");
		}
		CustomerEntity entity=mapper.mapToCustomerEntity(customer);
		em.persist(entity);
		customer.setId(entity.getPk());
		return customer;
	}

	@Override
	public CustomerData modifyCustomer(CustomerData customer) {//this is created as a void by the teacher
		
		CustomerEntity entity=em.find(CustomerEntity.class, customer.getId());
		entity=mapper.mapToCustomerEntity(entity,customer);
		em.persist(entity);
		return customer;
	}

	@Override
	public CustomerData findCustomer(Long id) {
		final CustomerEntity entity=em.find(CustomerEntity.class, id);
		if(entity==null) {
			throw new NoRecordFoundException("The customer with id="+id+"is not found ");
		}
		final CustomerData result=mapper.mapToCustomerData(entity);
		return result;
	}

	@Override
	public List<CustomerData> searchCustomer(String name) {
		String search=name+"%";
		final TypedQuery<CustomerEntity> query=em.createNamedQuery(QueryConstant.CUSTOMER_SEARCH, CustomerEntity.class);
		query.setParameter("searchStr", search);
		final List<CustomerEntity> results=query.getResultList();
		return mapper.mapToCustomerDataList(results);
	}

	@Override
	public void removeCustomer(Long id) {
		final CustomerEntity entity=em.find(CustomerEntity.class, id);
		em.remove(entity);

	}

}
