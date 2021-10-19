package br.com.vendas.repositories;

import br.com.vendas.models.OrderItem;
import br.com.vendas.models.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>  {

    //List<OrderItem> findAllById_Order(OrderItemPK id);

}
