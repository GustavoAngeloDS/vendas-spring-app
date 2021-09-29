package br.com.vendas.controllers;

import br.com.vendas.dtos.OrderDto;
import br.com.vendas.dtos.OrderItemDto;
import br.com.vendas.dtos.ProductDto;
import br.com.vendas.models.Order;
import br.com.vendas.models.OrderItem;
import br.com.vendas.models.Product;
import br.com.vendas.repositories.OrderRepository;
import br.com.vendas.repositories.ProductRepository;
import br.com.vendas.services.ClientService;
import br.com.vendas.services.OrderItemService;
import br.com.vendas.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody @Valid OrderItemDto orderItemDto ){


        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderItemDto, orderItem);

        return orderItemService.save(orderItem);
    }

    @GetMapping
    public List<OrderItem> findAll(){
        return orderItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value="id") Integer productId){
        return orderItemService.findById(productId);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody OrderItem orderItem){
        return orderItemService.remove(orderItem);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody OrderItem orderItem){
        return orderItemService.update(orderItem);
    }
}
