package br.com.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaConsultaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaEditaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
	List<PessoaListResponse> listaPessoas();
	PessoaConsultaResponse buscaPessoaAtravesId(UUID idPessoa);
	void patchEditaPessoa(UUID idPessoa, PessoaEditaRequest pessoaEditaRequest);
}