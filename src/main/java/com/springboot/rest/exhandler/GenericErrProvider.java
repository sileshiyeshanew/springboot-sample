package com.springboot.rest.exhandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.springboot.rest.data.ErrorResponse;
@Provider
public class GenericErrProvider implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception exception) {
		final ErrorResponse entity= new ErrorResponse();
		entity.setErrorCode("CUSTOMER-102");
		entity.setErrorDecs(exception.getMessage());

		return Response.status(510).entity(entity).build() ;
	}

}
