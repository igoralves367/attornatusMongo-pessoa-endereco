package br.com.attornatus.pessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoResponse;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecosListResponse;
import br.com.attornatus.pessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
	private final PessoaService pessoaService;
	private final EnderecoRepository enderecoRepository;

	@Override
	public EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		pessoaService.buscaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository.salvaEndereco(new Endereco(idPessoa, enderecoRequest));
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return new EnderecoResponse(endereco.getIdEndereco());
	}

	@Override
	public List<EnderecosListResponse> buscarEnderecosDaPessoa(UUID idPessoa) {
		log.info("[inicia] EnderecoApplicationService - buscarEnderecosDaPessoa");
		List<Endereco> enderecos = enderecoRepository.buscarEnderecosDaPessoa(idPessoa);
		log.info("[finaliza] EnderecoApplicationService - buscarEnderecosDaPessoa");
		return EnderecosListResponse.converte(enderecos);
	}
}