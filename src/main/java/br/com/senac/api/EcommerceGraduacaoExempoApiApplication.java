package br.com.senac.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EcommerceGraduacaoExempoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceGraduacaoExempoApiApplication.class, args);
	}


}
