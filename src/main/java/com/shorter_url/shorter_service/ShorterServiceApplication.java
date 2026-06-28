package com.shorter_url.shorter_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShorterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShorterServiceApplication.class, args);
	}

}
