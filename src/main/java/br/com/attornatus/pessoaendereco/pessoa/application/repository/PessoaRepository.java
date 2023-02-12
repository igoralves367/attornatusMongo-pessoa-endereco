package br.com.attornatus.pessoaendereco.pessoa.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
	List<Pessoa> listaPessoas();
	Pessoa buscaPessoaAtravesId(UUID idPessoa);
}