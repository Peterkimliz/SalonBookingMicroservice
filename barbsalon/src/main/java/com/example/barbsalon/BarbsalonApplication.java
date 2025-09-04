package com.example.barbsalon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class BarbsalonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbsalonApplication.class, args);
	}

}
