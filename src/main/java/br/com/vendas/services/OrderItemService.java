package br.com.vendas.services;

import br.com.vendas.models.OrderItem;
import br.com.vendas.repositories.OrderItemRepository;
import br.com.vendas.responses.ResponseOrderItemsByCpf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll () {
        return orderItemRepository.findAll();
    }

    public OrderItem findById(Integer id) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        return orderItem.get();
    }

    public OrderItem save(OrderItem orderItem){
        OrderItem newOrderItem = orderItemRepository.save(orderItem);
        return newOrderItem;
    }
    
    public void remove(OrderItem orderItem) {
        Optional<OrderItem> orderToRemove = orderItemRepository.findById(orderItem.getId());

        if(orderToRemove.isPresent()) {
            orderItemRepository.delete(orderItem);
        }
    }

	public List<ResponseOrderItemsByCpf> findOrderItemsByCpf(String cpf) {
    	List<ResponseOrderItemsByCpf> listOrderItemsResponse = new ArrayList<ResponseOrderItemsByCpf>(); 
    	List<OrderItem> listOrderItems = orderItemRepository.findOrderItemsByCpf(cpf);
    	
    	for(OrderItem orderItem : listOrderItems) {
    		ResponseOrderItemsByCpf responseOrderItem = ResponseOrderItemsByCpf.builder()
    				.quantity(orderItem.getQuantity())
    				.description(orderItem.getProduct().getDescription())
    				.build();  
    		
    		listOrderItemsResponse.add(responseOrderItem);
    	}
    	return listOrderItemsResponse;
    }
}
