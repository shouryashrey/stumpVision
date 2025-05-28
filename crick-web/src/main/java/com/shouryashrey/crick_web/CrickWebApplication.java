package com.shouryashrey.crick_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.shouryashrey.crick_dao.repos")
@ComponentScan(basePackages = {
		"com.shouryashrey.crick_model",
		"com.shouryashrey.crick_dao.repos",
		"com.shouryashrey.crick_kafka",
		"com.shouryashrey.crick_service",
		"com.shouryashrey.*",
		"com.shouryashrey.crick_web",
		"com.shouryashrey.crick_exception_handler"
})
@EntityScan(basePackages = "com.shouryashrey.crick_model")
@EnableAsync
public class CrickWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrickWebApplication.class, args);
	}

}
