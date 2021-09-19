package br.com.vendas.controllers;

import br.com.vendas.dtos.OrderDto;
import br.com.vendas.dtos.ProductDto;
import br.com.vendas.models.Order;
import br.com.vendas.models.Product;
import br.com.vendas.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid OrderDto orderDto){
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);

        return orderService.save(order);
    }


}
