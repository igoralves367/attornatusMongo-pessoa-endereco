package br.com.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaConsultaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaEditaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
	private final PessoaRepository pessoaRepository;

	@Override
	public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return PessoaResponse.builder()
				.idPessoa(pessoa.getIdPessoa())
				.build();
	}

	@Override
	public List<PessoaListResponse> listaPessoas() {
		log.info("[inicia] PessoaApplicationService - listaPessoas");
		List<Pessoa> pessoas = pessoaRepository.listaPessoas();
		log.info("[finaliza] PessoaApplicationService - listaPessoas");
		return PessoaListResponse.converte(pessoas);
	}

	@Override
	public PessoaConsultaResponse buscaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaPessoaAtravesId");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - buscaPessoaAtravesId");
		return new PessoaConsultaResponse(pessoa);
	}

	@Override
	public void patchEditaPessoa(UUID idPessoa, PessoaEditaRequest pessoaEditaRequest) {
		log.info("[inicia] PessoaApplicationService - patchEditaPessoa");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		pessoa.altera(pessoaEditaRequest);
		pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - patchEditaPessoa");	
	}
}