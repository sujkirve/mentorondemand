package com.ibm.mentors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MentorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorsApplication.class, args);
	}

}
