package com.springboot.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorldRest {
	@GET
	public String welcome() {
		return "welcome to Rest Webservices";
	}

}
