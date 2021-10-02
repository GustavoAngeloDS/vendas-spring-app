package br.com.vendas.services;

import br.com.vendas.models.Order;
import br.com.vendas.models.OrderItem;
import br.com.vendas.repositories.OrderItemRepository;
import br.com.vendas.repositories.OrderRepository;
import br.com.vendas.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll () {
        return orderItemRepository.findAll();
    }

    public ResponseEntity<?> findById(Integer id) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        ResponseEntity<?> response;

        response = orderItem.isPresent() ?
                new ResponseEntity<>(orderItem.get(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return response;
    }

    public ResponseEntity<?> save(OrderItem orderItem){
        OrderItem newOrderItem = orderItemRepository.save(orderItem);
        return new ResponseEntity<>(newOrderItem, HttpStatus.OK);
    }

    public ResponseEntity<?> update(OrderItem orderItem) {
        Optional<OrderItem> orderItemToUpdate = orderItemRepository.findById(orderItem.getId());
        ResponseEntity<?> response;

        if(orderItemToUpdate.isPresent()) {
            response = new ResponseEntity<>(orderItemRepository.save(orderItem), HttpStatus.OK);
        }
        else
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return response;
    }

    public ResponseEntity<?> remove(OrderItem orderItem) {
        Optional<OrderItem> orderToRemove = orderItemRepository.findById(orderItem.getId());
        ResponseEntity<?> response;

        if(orderToRemove.isPresent()) {
            orderItemRepository.delete(orderItem);
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
