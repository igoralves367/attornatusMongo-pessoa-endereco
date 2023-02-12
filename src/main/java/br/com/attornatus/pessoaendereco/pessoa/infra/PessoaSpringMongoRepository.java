package br.com.attornatus.pessoaendereco.pessoa.infra;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaSpringMongoRepository extends MongoRepository<Pessoa, UUID>{
}