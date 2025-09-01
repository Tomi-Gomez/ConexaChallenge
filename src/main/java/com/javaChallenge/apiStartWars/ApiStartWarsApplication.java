package com.javaChallenge.apiStartWars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.javaChallenge.apiStartWars.clients.StarWars")
public class ApiStartWarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStartWarsApplication.class, args);
	}

}
