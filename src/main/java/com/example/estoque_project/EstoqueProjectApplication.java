package com.example.estoque_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"estoque.*"})
@EntityScan(basePackages = "estoque.model")
@SpringBootApplication
public class EstoqueProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueProjectApplication.class, args);
	}

}
