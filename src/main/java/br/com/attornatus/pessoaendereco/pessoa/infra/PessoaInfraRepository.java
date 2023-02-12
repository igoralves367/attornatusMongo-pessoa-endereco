package br.com.attornatus.pessoaendereco.pessoa.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.attornatus.pessoaendereco.handler.APIException;
import br.com.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
	private final PessoaSpringDataJPARepository pessoaSpringDataJPARepository;

	@Override
	public Pessoa salva(Pessoa pessoa) {
		log.info("[inicia] PessoaInfraRepository - salva");
		pessoaSpringDataJPARepository.save(pessoa);
		log.info("[finaliza] PessoaInfraRepository - salva");
		return pessoa;
	}

	@Override
	public List<Pessoa> listaPessoas() {
		log.info("[inicia] PessoaInfraRepository - listaPessoas");
		List<Pessoa> todasPessoas = pessoaSpringDataJPARepository.findAll();
		log.info("[finaliza] PessoaInfraRepository - listaPessoas");
		return todasPessoas;
	}

	@Override
	public Pessoa buscaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaInfraRepository - buscaPessoaAtravesId");
		Pessoa pessoa = pessoaSpringDataJPARepository.findById(idPessoa)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrado"));
		log.info("[finaliza] PessoaInfraRepository - buscaPessoaAtravesId");
		return pessoa;
	}
}