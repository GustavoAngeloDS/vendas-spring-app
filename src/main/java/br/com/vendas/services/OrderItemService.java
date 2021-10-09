package br.com.vendas.services;

import br.com.vendas.models.OrderItem;
import br.com.vendas.repositories.OrderItemRepository;
import br.com.vendas.responses.ResponseOrderItems;
import br.com.vendas.responses.ResponseOrdersByCpf;

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

	public ResponseOrdersByCpf findOrderItemsByCpf(String cpf) {
    	List<OrderItem> orderItemsList = orderItemRepository.findOrderItemsByCpf(cpf);
    	List<ResponseOrderItems> responseOrderItemsList = new ArrayList<ResponseOrderItems>(); 
    	
    	for(OrderItem orderItem : orderItemsList) {
    		ResponseOrderItems responseOrderItems = ResponseOrderItems.builder()
    				.orderId(orderItem.getOrder().getId())
    				.productId(orderItem.getProduct().getId())
    				.description(orderItem.getProduct().getDescription())
    				.quantity(orderItem.getQuantity())
    				.build();
    		    		
    		responseOrderItemsList.add(responseOrderItems);
    	}
    	
    	ResponseOrdersByCpf responseOrderByCpf = ResponseOrdersByCpf.builder()
    			.orderId(responseOrderItemsList.get(0).getOrderId())
    			.orderItemsList(responseOrderItemsList)
    			.build();
    	
    	return responseOrderByCpf;
    }
}
