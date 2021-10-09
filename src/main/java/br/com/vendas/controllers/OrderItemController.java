package br.com.vendas.controllers;

import br.com.vendas.dtos.OrderItemDto;
import br.com.vendas.models.Order;
import br.com.vendas.models.OrderItem;
import br.com.vendas.responses.ResponseOrderItemsByCpf;
import br.com.vendas.services.OrderItemService;
import br.com.vendas.services.OrderService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;
    
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody @Valid OrderItemDto orderItemDto){
        ResponseEntity<?> responseEntity;
    	OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderItemDto, orderItem);
        
        Order order = orderService.save(orderItem.getOrder());
        
        if(Objects.isNull(order))
        	responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else {
        	orderItem.setOrder(order);
        	responseEntity = new ResponseEntity<>(orderItemService.save(orderItem), HttpStatus.OK); 
        }
        	
        return responseEntity;
    }

    @GetMapping
    public List<OrderItem> findAll(){
        return orderItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value="id") Integer orderItemId){
        OrderItem orderItem = orderItemService.findById(orderItemId);
        ResponseEntity<?> responseEntity;
        if(Objects.isNull(orderItem))
        	responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
        	responseEntity = new ResponseEntity<>(orderItem, HttpStatus.OK);
    	
        return responseEntity; 
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody OrderItem orderItem){
    	ResponseEntity<?> responseEntity = new ResponseEntity<>(HttpStatus.OK);
    	orderItemService.remove(orderItem);
    	
    	return responseEntity;
    }
     
    @GetMapping("/find-by-cpf/{cpf}")
    public List<ResponseOrderItemsByCpf> findOrderItemsByCpf(@PathVariable(value = "cpf") String cpf){
    	return orderItemService.findOrderItemsByCpf(cpf);
    }
}
