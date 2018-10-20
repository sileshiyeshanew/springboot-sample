package com.springboot.rest.exhandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springboot.rest.CustomerRest;
import com.springboot.rest.data.ErrorResponse;
import com.springboot.rest.exception.InvalidDataException;

@Provider
public class InvalidDataProvider implements ExceptionMapper<InvalidDataException> {
	
	private final static Logger logger=LoggerFactory.getLogger(InvalidDataProvider.class.getName());
	
	@Override
	public Response toResponse(InvalidDataException exception) {
		logger.debug("Invalid Data {} ", exception);
		final ErrorResponse entity= new ErrorResponse();
		entity.setErrorCode("CUSTOMER-100");
		entity.setErrorDecs("Invalid data to create or update customer");
		return Response.status(510).type(MediaType.APPLICATION_JSON).entity(entity).build() ;
	}

}
