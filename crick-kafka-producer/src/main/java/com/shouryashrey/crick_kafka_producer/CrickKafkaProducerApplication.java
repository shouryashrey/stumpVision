package com.shouryashrey.crick_kafka_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shouryashrey.crick_kafka_producer", "com.shouryashrey.crick_model", "com.shouryashrey.crick_exception_handler"})
public class CrickKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrickKafkaProducerApplication.class, args);
	}

}
