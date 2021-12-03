package com.shopeefood.clone.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}

//@Configuration
//class RestTemplateConfig {
//
//	// Create a bean for restTemplate to call services
//	@Bean
//	@LoadBalanced        // Load balance between service instances running at different ports.
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
//}
