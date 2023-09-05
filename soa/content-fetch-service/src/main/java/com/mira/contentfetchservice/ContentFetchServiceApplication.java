package com.mira.contentfetchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ContentFetchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentFetchServiceApplication.class, args);
	}

}
