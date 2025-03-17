package com.shouryashrey.crick_web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@ComponentScan(basePackages = "com.shouryashrey")
@EntityScan(basePackages = "com.shouryashrey.crick_model")
class CrickWebApplicationTests {

	@Test
	void contextLoads() {
	}

}
