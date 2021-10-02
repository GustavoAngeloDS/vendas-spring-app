package br.com.vendas.controllers;

import br.com.vendas.dtos.OrderDto;
import br.com.vendas.dtos.ProductDto;
import br.com.vendas.models.Order;
import br.com.vendas.models.Product;
import br.com.vendas.services.ClientService;
import br.com.vendas.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody @Valid OrderDto orderDto){
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);

        return orderService.save(order);
    }

    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value="id") Integer productId){
        return orderService.findById(productId);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Order order){
        return orderService.remove(order);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Order order){
        return orderService.update(order);
    }
}
