package com.empresa.API_empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.empresa.API_empresa")
public class ApiEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEmpresaApplication.class, args);
	}

}
