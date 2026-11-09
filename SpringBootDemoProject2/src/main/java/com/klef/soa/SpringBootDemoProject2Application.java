package com.klef.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootDemoProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoProject2Application.class, args);
		System.out.println("Project is running...!!!"); 
	}

	@Bean
	public RestTemplate reatTemplate() {
		return new RestTemplate();
	}
}
