package br.com.vendas.services;

import br.com.vendas.models.Order;
import br.com.vendas.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> findAll () {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Integer id) {        
        return orderRepository.findById(id);
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        Optional<Order> orderToUpdate = orderRepository.findById(order.getId());
        Order updatedOrder = new Order();

        if(orderToUpdate.isPresent())
        	updatedOrder = orderRepository.save(order);
        
        return updatedOrder;
    }

    public void remove(Order order) {
        Optional<Order> orderToRemove = orderRepository.findById(order.getId());
        
        if(orderToRemove.isPresent()) 
            orderRepository.delete(order);
    }
}
