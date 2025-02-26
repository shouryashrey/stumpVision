package com.shouryashrey.crick_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shouryashrey.crick_service", "com.shouryashrey.crick_web"})
public class CrickWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrickWebApplication.class, args);
	}

}
