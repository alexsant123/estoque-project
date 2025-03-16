package com.example.estoque_project;

import estoque.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages= {"estoque.*"})
@EntityScan(basePackages = "estoque.model")
@EnableJpaRepositories(basePackages = {"estoque.repository"})
@SpringBootApplication
public class EstoqueProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueProjectApplication.class, args);


	}

}
