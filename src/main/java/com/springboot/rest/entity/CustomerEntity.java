package com.springboot.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@NamedQuery(name=QueryConstant.CUSTOMER_SEARCH,query="select c from CustomerEntity c where UPR(c.firstName) like UPPER(:searchStr) OR UPPER(c.lastName) like UPPER(:searchStr)")
public class CustomerEntity {
	@Id
	@Column(name = "CUSTOMER_ID")
	@SequenceGenerator(name = "cSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "cSeq")
	private Long pk;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "SSN")
	private String ssn;

	public CustomerEntity() {
		
	}
	
	public CustomerEntity(Long pk, String firstName, String lastName, String ssn) {
		super();
		this.pk = pk;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}
	public Long getPk() {
		return pk;
	}
	public void setPk(Long pk) {
		this.pk = pk;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "CustomerEntity [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn
				+ "]";
	}
	

}
