package br.com.vendas.repositories;

import br.com.vendas.models.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>  {
	
}