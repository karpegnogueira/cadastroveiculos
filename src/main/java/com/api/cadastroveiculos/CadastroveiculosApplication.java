package com.api.cadastroveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cadastro de Veiculos API", version = "1.0", description = "Cadastro de Veiculos"))
public class CadastroveiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroveiculosApplication.class, args);
	}

}
