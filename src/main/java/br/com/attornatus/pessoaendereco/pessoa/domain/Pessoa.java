package br.com.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaEditaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idPessoa;
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Pessoa(PessoaRequest pessoaRequest) {
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