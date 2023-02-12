package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoaendereco.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
	private final EnderecoService enderecoService;

	@Override
	public EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoController - postEndereco");
		log.info("[idPessoa] {}", idPessoa);
		EnderecoResponse endereco = enderecoService.criaEndereco(idPessoa, enderecoRequest);
		log.info("[finaliza] EnderecoController - postEndereco");
		return endereco;
	}

	@Override
	public List<EnderecosListResponse> getEnderecosDaPessoa(UUID idPessoa) {
		log.info("[inicia] EnderecoController - postEndereco");
		log.info("[idPessoa] {}", idPessoa);
		List<EnderecosListResponse> enderecosPessoa = enderecoService.buscarEnderecosDaPessoa(idPessoa);
		log.info("[finaliza] EnderecoController - postEndereco");
		return enderecosPessoa;
	}
}