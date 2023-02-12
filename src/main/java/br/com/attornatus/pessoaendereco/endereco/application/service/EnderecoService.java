package br.com.attornatus.pessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoResponse;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecosListResponse;

public interface EnderecoService {
	EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest);
	List<EnderecosListResponse> buscarEnderecosDaPessoa(UUID idPessoa);
}