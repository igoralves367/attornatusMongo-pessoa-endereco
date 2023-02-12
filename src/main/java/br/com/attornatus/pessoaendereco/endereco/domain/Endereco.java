package br.com.attornatus.pessoaendereco.endereco.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Endereco")
public class Endereco {
	
	@Id
	private UUID idEndereco;
	@NotNull
	private UUID idPessoaCadastro;
	@NotBlank
	private String lagradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	private TipoEndereco tipoEndereco;
	
	private LocalDateTime dataHoraDoCadastro;
	
	public Endereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
		this.idEndereco = UUID.randomUUID();
		this.idPessoaCadastro = idPessoa;
		this.lagradouro = enderecoRequest.getLagradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade = enderecoRequest.getCidade();
		this.tipoEndereco = enderecoRequest.getTipoEndereco();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}	
}