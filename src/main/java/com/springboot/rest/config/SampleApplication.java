package com.springboot.rest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:SpringJPA.xml")//we have to give the class path
@ComponentScan("com.springboot.rest")
public class SampleApplication {

	public static void main(String[] args)  throws Exception{
		
		SpringApplication.run(SampleApplication.class, args);
	}
}
