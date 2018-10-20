package com.springboot.rest.service;

import java.util.List;

import com.springboot.rest.data.CustomerData;

public interface CustomerService {
	CustomerData createCustomer(final CustomerData customer);

	CustomerData modifyCustomer(final CustomerData customer);

	CustomerData findCustomer(final Long id);

	List<CustomerData> searchCustomer(final String name);

	void removeCustomer(final Long id);

}
