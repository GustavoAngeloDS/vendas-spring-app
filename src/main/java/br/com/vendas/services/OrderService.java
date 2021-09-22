package br.com.vendas.services;

import br.com.vendas.models.Order;
import br.com.vendas.models.Product;
import br.com.vendas.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> findById(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        ResponseEntity<?> response;

        response = order.isPresent() ?
                new ResponseEntity<>(order.get(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return response;
    }

    public ResponseEntity<?> save(Order order){
        Order newOrder = orderRepository.save(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    public ResponseEntity<?> update(Order order) {
        Optional<Order> orderToUpdate = orderRepository.findById(order.getId());
        ResponseEntity<?> response;

        if(orderToUpdate.isPresent()) {
            response = new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
        }
        else
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return response;
    }

    public ResponseEntity<?> remove(Order order) {
        Optional<Order> orderToRemove = orderRepository.findById(order.getId());
        ResponseEntity<?> response;

        if(orderToRemove.isPresent()) {
            orderRepository.delete(order);
            response = new ResponseEntity<>(HttpStatus.OK);
        }
        else
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return response;
    }


    //  Pesquisa por CPF
    //    public ResponseEntity<?> findByCpf(String cpf) {
    //
    //    }

}
