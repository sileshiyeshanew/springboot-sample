package com.springboot.rest.config;

import org.glassfish.jersey.server.ResourceConfig;//Jersey configuration class
import org.springframework.context.annotation.Configuration;

import com.springboot.rest.CustomerRest;
import com.springboot.rest.HelloWorldRest;
import com.springboot.rest.exhandler.GenericErrProvider;
import com.springboot.rest.exhandler.InvalidDataProvider;
import com.springboot.rest.exhandler.NoRecordFoundProvider;
//@Configuration tags this 'class' as a source of bean definitions for the 'application context'.
@Configuration
public class SampleRestConfig extends ResourceConfig {//Jersey configuration class
	public SampleRestConfig() {
		register(HelloWorldRest.class);
		register(CustomerRest.class);
		register(GenericErrProvider.class);
		register(NoRecordFoundProvider.class);
		register(InvalidDataProvider.class);

	}
}
