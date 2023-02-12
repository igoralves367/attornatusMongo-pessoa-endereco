package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;
@Value
public class PessoaListResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	
	public static List<PessoaListResponse> converte(List<Pessoa> pessoas) {
		return pessoas.stream()
				.map(PessoaListResponse::new)
				.collect(Collectors.toList());
	}

	public PessoaListResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.dataNascimento = pessoa.getDataNascimento();
	}
}