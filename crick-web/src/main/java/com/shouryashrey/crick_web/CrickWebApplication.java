package com.shouryashrey.crick_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.Duration;

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
@EnableCaching
public class CrickWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrickWebApplication.class, args);
	}

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig() //
				.prefixCacheNameWith(this.getClass().getPackageName() + ".") //
				.entryTtl(Duration.ofHours(1)) //
				.disableCachingNullValues();

		return RedisCacheManager.builder(connectionFactory) //
				.cacheDefaults(config) //
				.build();
	}

}
