package br.com.attornatus.pessoaendereco.endereco.infra;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;

public interface EnderecoSpringMongoRepository extends MongoRepository<Endereco, UUID>{
}