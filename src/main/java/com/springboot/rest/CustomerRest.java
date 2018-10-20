package com.springboot.rest;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.service.CustomerService;

@Path("/customer")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CustomerRest {
	
	private static Logger logger=LoggerFactory.getLogger(CustomerRest.class.getName());
	
	@Autowired
	@Qualifier("csSpringDataImpl")//used to be specific, when there are more than one implementations 
	private CustomerService cs;
	
	
	/*@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCustomer() {
		final CustomerData entity=new CustomerData("sileshi","yeshanew","12344") ;
		return Response.ok().build();
	}*/

	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public Response create(final CustomerData customer) {
		
		logger.debug("Entring customerRest.create");
		logger.debug("Customer Data {}");
		logger.debug("Calling customer service");
		final CustomerData entity=cs.createCustomer(customer);
		logger.debug("Customer created successfully");
		ResponseBuilder rb=Response.ok();
		if(customer.getFirstName().startsWith("R")) {
			rb=rb.type(MediaType.APPLICATION_XML);
		}
		else {
			rb=rb.type(MediaType.APPLICATION_JSON);
		}
		return rb.entity(entity).build();
		//return Response.ok().entity(entity).build();//this responds back to the client 
	}
	
	@GET
	@Path("/{custId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response find(@PathParam("custId")final Long key) {
		final CustomerData entity=cs.findCustomer(key);
		return Response.ok().entity(entity).build();
	}
	
	@GET
	public Response search(@QueryParam("searchStr")final String name) {
		final List<CustomerData> customerResult=cs.searchCustomer(name);
		CustomerSearchResults entity=new CustomerSearchResults(customerResult);
		return Response.ok().entity(entity).build();
	}

		@GET
		@Path("/searchByMatrix")
		public Response searchByMatrix(@MatrixParam("searchStr")final String name) {
			final List<CustomerData> customerResult=cs.searchCustomer(name);
			CustomerSearchResults entity=new CustomerSearchResults(customerResult);
			return Response.ok().entity(entity).build();
	}
	@PUT
	public Response modify(final CustomerData customer) {
	CustomerData custom=cs.modifyCustomer(customer);
	if(custom!=null) {
		return Response.ok().entity(custom).build();
	}else {
		return Response.noContent().build();
	}
	}
	@DELETE
	@Path("/{custId}")
	public Response remove(@PathParam("custId")final Long key) {
		cs.removeCustomer(key);
		return Response.noContent().build();
	}
	
	@GET
	@Path("/hdr")
	public Response sampleHdr(@HeaderParam("auth-key")final String authKey,@HeaderParam("app-vesrion")final String appVersion) throws JSONException {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("authKey", authKey);
		jsonObj.put("appVersion", appVersion);
		
		return Response.ok().entity(jsonObj.toString()).build();
}
	
}
	
