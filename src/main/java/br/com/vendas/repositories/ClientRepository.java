package br.com.vendas.repositories;

import br.com.vendas.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE c.cpf = :cpf and c.id <> :id")
    public Optional<Client> findClientByCpf(String cpf, Integer id);
}
