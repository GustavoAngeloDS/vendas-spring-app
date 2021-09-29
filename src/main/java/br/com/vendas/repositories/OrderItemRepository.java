package br.com.vendas.repositories;

import br.com.vendas.models.Order;
import br.com.vendas.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>  {

}
