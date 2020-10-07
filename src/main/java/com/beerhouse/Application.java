package com.beerhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.beerhouse.controllers.CraftBeerController;

@SpringBootApplication
@ComponentScan(basePackages = "com.beerhouse")
@ComponentScan(basePackageClasses = CraftBeerController.class)
@EntityScan("com.beerhouse.models")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}