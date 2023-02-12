package br.com.attornatus.pessoaendereco.pessoa.infra;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaSpringDataJPARepository extends JpaRepository<Pessoa, UUID>{
}