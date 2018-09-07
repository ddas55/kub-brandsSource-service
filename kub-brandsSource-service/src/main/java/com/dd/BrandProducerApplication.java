package com.dd;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;

@EnablePrometheusEndpoint
@SpringBootApplication
//@EnableResourceServer//tells Spring Cloud and Spring Security that the service is a protected resource.
public class BrandProducerApplication{
		
	  
	//Main Apps
	public static void main(String[] args) {
		SpringApplication.run(BrandProducerApplication.class, args);
	}
}
