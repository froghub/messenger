package com.web.messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EntityScan

@EnableJpaRepositories
public class Main {
	public static ConfigurableApplicationContext ctx;
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
	}
}
