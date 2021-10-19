package br.com.vendas.repositories;

import br.com.vendas.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer>  {

    List<Order> findByclient_id(Integer client_id);



}
