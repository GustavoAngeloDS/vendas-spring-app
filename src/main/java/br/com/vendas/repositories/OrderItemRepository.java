package br.com.vendas.repositories;

import br.com.vendas.models.OrderItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>  {
	
	@Query("SELECT oi, p FROM OrderItem oi INNER JOIN oi.order o INNER JOIN o.client c INNER JOIN oi.product p where c.cpf = :cpf")
	public List<OrderItem> findOrderItemsByCpf(String cpf);
}
