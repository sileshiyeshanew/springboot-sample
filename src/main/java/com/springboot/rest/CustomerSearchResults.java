package com.springboot.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.springboot.rest.data.CustomerData;

@XmlRootElement
public class CustomerSearchResults {
	private List<CustomerData> customers;

	public CustomerSearchResults() {
		super();

	}

	public CustomerSearchResults(List<CustomerData> customers) {
		super();
		this.customers = customers;
	}

	public List<CustomerData> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerData> customers) {
		this.customers = customers;
	}

}
