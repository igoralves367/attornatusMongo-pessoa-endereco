package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoaendereco.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {
	private final PessoaService pessoaService;

	@Override
	public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaResponse pessoaResponse = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaResponse;
	}

	@Override
	public List<PessoaListResponse> getListaPessoas() {
		log.info("[inicia] PessoaController - getListaPessoas");
		List<PessoaListResponse> pessoas = pessoaService.listaPessoas();
		log.info("[finaliza] PessoaController - getListaPessoas");
		return pessoas;
	}

	@Override
	public PessoaConsultaResponse getPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaController - getPessoaAtravesId");
		log.info("[idPessoa] {}", idPessoa);
		PessoaConsultaResponse pessoaConsulta = pessoaService.buscaPessoaAtravesId(idPessoa);
		log.info("[finaliza] PessoaController - getPessoaAtravesId");
		return pessoaConsulta;
	}

	@Override
	public void patchEditaPessoa(UUID idPessoa, PessoaEditaRequest PessoaEditaRequest) {
		log.info("[inicia] PessoaController - patchEditaPessoa");
		log.info("[idPessoa] {}", idPessoa);
		pessoaService.patchEditaPessoa(idPessoa, PessoaEditaRequest);
		log.info("[finaliza] PessoaController - patchEditaPessoa");	
	}
}