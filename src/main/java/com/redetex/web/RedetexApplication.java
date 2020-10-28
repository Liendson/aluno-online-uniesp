package com.redetex.web;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedetexApplication {

	private static final Logger log = LoggerFactory.getLogger(RedetexApplication.class);

	public static void main(String[] args) {

		log.info("Inicializando Aplicação REDETEX");
		SpringApplication.run(RedetexApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
