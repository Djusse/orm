package com.polytechnique.orm;

import com.polytechnique.orm.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrmApplication.class, args);
	}
}