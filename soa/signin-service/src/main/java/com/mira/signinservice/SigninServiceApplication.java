package com.mira.signinservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SigninServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigninServiceApplication.class, args);
	}

}
