package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.endereco.domain.TipoEndereco;
import lombok.Value;
@Value
public class EnderecosListResponse {
	private UUID idEndereco;
	private String lagradouro;
	private String cep;
	private String numero;
	private String cidade;
	private TipoEndereco tipoEndereco;
	
	public static List<EnderecosListResponse> converte(List<Endereco> enderecos) {
		return enderecos.stream()
				.map(EnderecosListResponse::new)
				.collect(Collectors.toList());
	}

	public EnderecosListResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.lagradouro = endereco.getLagradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.tipoEndereco = endereco.getTipoEndereco();
	}	
}