package br.com.marketplace.repositories;

import br.com.marketplace.models.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, String> {
}
