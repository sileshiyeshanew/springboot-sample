package com.springboot.rest.exhandler;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.springboot.rest.data.ErrorResponse;
import com.springboot.rest.exception.NoRecordFoundException;
@Provider
public class NoRecordFoundProvider implements ExceptionMapper<NoRecordFoundException >  {

	@Override
	public Response toResponse(NoRecordFoundException exception) {
		final ErrorResponse entity= new ErrorResponse();
		entity.setErrorCode("CUSTOMER-101");
		entity.setErrorDecs(exception.getMessage());
		return Response.status(509).entity(entity).build() ;
	}

}
