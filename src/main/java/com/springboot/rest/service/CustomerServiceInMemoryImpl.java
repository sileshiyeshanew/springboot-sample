package com.springboot.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.data.CustomerData;

@Service
@Transactional
public class CustomerServiceInMemoryImpl implements CustomerService {
	private Map<Long, CustomerData> custmerDBMap = new HashMap<Long, CustomerData>();

	@Override
	public CustomerData createCustomer(CustomerData customer) {
		if (customer != null) {
			customer.setId(System.currentTimeMillis());
			custmerDBMap.put(customer.getId(), customer);
		}
		return customer;
	}

	@Override
	public CustomerData modifyCustomer(CustomerData customer) {
		CustomerData cutom;
		if (custmerDBMap.containsKey(customer.getId())) {
			custmerDBMap.put(customer.getId(), customer);
			cutom = custmerDBMap.get(customer.getId());
		} else {
			throw new RuntimeException("no customer found in the database");
		}
		return cutom;

	}

	@Override
	public CustomerData findCustomer(Long id) {

		return custmerDBMap.get(id);
	}

	@Override
	public List<CustomerData> searchCustomer(String name) {
		List<CustomerData> result = new ArrayList<CustomerData>();
		Collection<CustomerData> allCollections = custmerDBMap.values();
		for (CustomerData cData : allCollections) {
			if (cData.getFirstName().toLowerCase().startsWith(name.toLowerCase())
					|| cData.getLastName().toLowerCase().startsWith(name.toLowerCase())) {
				result.add(cData);

			}
		}
		return result;
	}

	@Override
	public void removeCustomer(Long id) {
		if (custmerDBMap.containsKey(id)) {
			custmerDBMap.remove(id);
		} else {
			throw new RuntimeException("no customer found in the database");
		}

	}

}
