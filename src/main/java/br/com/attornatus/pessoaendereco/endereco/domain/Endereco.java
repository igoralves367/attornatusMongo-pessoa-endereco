package br.com.attornatus.pessoaendereco.endereco.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idEndereco;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idPessoa", nullable = false)
	private UUID idPessoaCadastro;
	@NotBlank
	private String lagradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	private TipoEndereco tipoEndereco = TipoEndereco.PRINCIPAL;
	
	private LocalDateTime dataHoraDoCadastro;
	
	public Endereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
		this.idPessoaCadastro = idPessoa;
		this.lagradouro = enderecoRequest.getLagradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade = enderecoRequest.getCidade();
		this.tipoEndereco = enderecoRequest.getTipoEndereco();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}	
}