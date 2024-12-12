package br.ifba.api.petcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class PetcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetcommerceApplication.class, args);
	}

}
