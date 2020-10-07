package com.beerhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.beerhouse.controllers.CraftBeerController;

@SpringBootApplication
@ComponentScan(basePackages = "com.beerhouse")
//@EnableJpaRepositories("com.beerhouse.repositories")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}