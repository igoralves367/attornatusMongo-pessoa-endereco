package br.com.attornatus.pessoaendereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
@SpringBootApplication
public class PessoaEnderecoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PessoaEnderecoApplication.class, args);
	}
}