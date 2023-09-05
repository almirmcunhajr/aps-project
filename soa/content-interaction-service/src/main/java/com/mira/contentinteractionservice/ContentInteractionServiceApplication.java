package com.mira.contentinteractionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ContentInteractionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentInteractionServiceApplication.class, args);
	}

}
