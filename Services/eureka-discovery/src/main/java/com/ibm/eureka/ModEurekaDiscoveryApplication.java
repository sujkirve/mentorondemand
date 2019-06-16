package com.ibm.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ModEurekaDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModEurekaDiscoveryApplication.class, args);
	}

}
