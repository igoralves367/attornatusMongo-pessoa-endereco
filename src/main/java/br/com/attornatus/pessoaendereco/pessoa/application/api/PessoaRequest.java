package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;
@Value
public class PessoaRequest {
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
}