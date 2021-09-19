package br.com.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendas.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
