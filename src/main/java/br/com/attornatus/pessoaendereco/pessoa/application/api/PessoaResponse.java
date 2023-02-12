package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class PessoaResponse {
	private UUID idPessoa;
}