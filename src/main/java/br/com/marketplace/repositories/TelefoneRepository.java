package br.com.marketplace.repositories;

import br.com.marketplace.models.Pessoa;
import br.com.marketplace.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Pessoa> {
}
