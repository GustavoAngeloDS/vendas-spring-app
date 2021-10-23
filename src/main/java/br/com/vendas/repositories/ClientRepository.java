package br.com.vendas.repositories;

import br.com.vendas.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE CONCAT (lower(name),' ', lower(lastname)) like %:text% OR c.cpf LIKE %:text%")
    public List<Client> findClientByText(@Param("text") String text);
  
    @Query("SELECT c FROM Client c WHERE c.cpf = :cpf and c.id <> :id")
    public Optional<Client> findClientByCpf(String cpf, Integer id);
  
}
