package br.com.fiap.imersao_2550;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.fiap.imersao_2550")
public class Imersao2550Application {

	public static void main(String[] args) {
		SpringApplication.run(Imersao2550Application.class, args);
	}

}
