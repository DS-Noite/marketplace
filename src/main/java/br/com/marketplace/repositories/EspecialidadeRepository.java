package br.com.marketplace.repositories;

import br.com.marketplace.models.Especialidade;
import br.com.marketplace.models.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Profissional> {
}
