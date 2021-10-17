package br.com.vendas.repositories;

import br.com.vendas.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE LOWER(c.name) LIKE %:text% OR LOWER(c.lastname) LIKE %:text% OR c.cpf LIKE %:text%" )
    public List<Client> findClientByText(@Param("text") String text);
}
