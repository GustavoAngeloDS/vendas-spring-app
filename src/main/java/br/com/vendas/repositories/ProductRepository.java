package br.com.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendas.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE LOWER(p.description) LIKE %:text%" )
    public List<Product> findProductByText(@Param("text") String text);
}
