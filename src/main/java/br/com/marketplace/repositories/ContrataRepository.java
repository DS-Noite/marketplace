package br.com.marketplace.repositories;

import br.com.marketplace.models.Contrata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContrataRepository extends JpaRepository<Contrata, Long> {
}
