package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;
@Value
public class PessoaConsultaResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	
	public PessoaConsultaResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.dataNascimento = pessoa.getDataNascimento();
	}
}