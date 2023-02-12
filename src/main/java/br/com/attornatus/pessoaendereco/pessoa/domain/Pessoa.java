package br.com.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaEditaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Pessoa")
public class Pessoa {
	
	@Id
	private UUID idPessoa;
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Pessoa(PessoaRequest pessoaRequest) {
		this.idPessoa = UUID.randomUUID();
		this.nomeCompleto = pessoaRequest.getNomeCompleto();
		this.dataNascimento = pessoaRequest.getDataNascimento();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(PessoaEditaRequest pessoaEditaRequest) {
		this.nomeCompleto = pessoaEditaRequest.getNomeCompleto();
		this.dataNascimento = pessoaEditaRequest.getDataNascimento();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
	}
}