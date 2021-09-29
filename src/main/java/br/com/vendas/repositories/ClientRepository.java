package br.com.vendas.repositories;

import br.com.vendas.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
