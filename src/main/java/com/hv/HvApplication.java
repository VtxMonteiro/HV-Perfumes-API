package com.hv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan (basePackages = {"com.gvendas.entidades;"})
@EnableJpaRepositories(basePackages = {"com.gvendas.repositorio"})
@ComponentScan (basePackages = {"com.gvendas.servico;", "com.gvendas.controlador;"})
@SpringBootApplication

public class HvApplication {

	public static void main(String[] args) {
	SpringApplication.run(HvApplication.class, args);
	}

}	
