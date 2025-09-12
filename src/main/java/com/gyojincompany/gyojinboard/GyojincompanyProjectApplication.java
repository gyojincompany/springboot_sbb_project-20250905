package com.gyojincompany.gyojinboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GyojincompanyProjectApplication extends SpringBootServletInitializer{
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(GyojincompanyProjectApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GyojincompanyProjectApplication.class, args);
	}

}
