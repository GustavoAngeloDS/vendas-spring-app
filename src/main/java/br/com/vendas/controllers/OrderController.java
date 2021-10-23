package br.com.vendas.controllers;

import br.com.vendas.models.Order;
import br.com.vendas.services.ClientService;
import br.com.vendas.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody @Valid Order obj){
        ResponseEntity<?> responseEntity;

        if(Objects.isNull(obj))
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else {
            responseEntity = new ResponseEntity<>(orderService.save(obj), HttpStatus.CREATED);
        }

        return responseEntity;
    }

    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable(value="id") Integer orderId){
        return orderService.findById(orderId);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Order order){
        return orderService.remove(order);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Order order){
        return orderService.update(order);
    }

    @GetMapping("/cpf/{cpf}")
    public List<Order> findByCPF(@PathVariable(value="cpf") String cpf){
        return orderService.findByCPF(cpf);
    }

}
