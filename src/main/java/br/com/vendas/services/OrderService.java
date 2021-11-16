package br.com.vendas.services;

import br.com.vendas.models.Client;
import br.com.vendas.models.Order;
import br.com.vendas.models.OrderItem;
import br.com.vendas.repositories.ClientRepository;
import br.com.vendas.repositories.OrderItemRepository;
import br.com.vendas.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ClientRepository clientRepository;


    //List All Orders
    public List<Order> findAll () {
        return orderRepository.findAll();
    }


    //Find Order by ID
    public Optional<Order> findById(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        ResponseEntity<?> response;

        if(order.isPresent())
                new ResponseEntity<>(order.get(), HttpStatus.OK);
        else
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return order;
    }

    //Save Order
    @Transactional
    public ResponseEntity<?> save(Order obj){
        obj.setId(null);
        obj.setDate(new Date());

        obj = orderRepository.save(obj);

        for(OrderItem oi : obj.getItems()){
            oi.setOrder(obj);
        }
        orderItemRepository.saveAll(obj.getItems());
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //Update a order
    @Transactional
    public ResponseEntity<?>  update(Order order) {

        Optional<Order> orderToUpdate = orderRepository.findById(order.getId());
        Order orderToUpdateList = orderToUpdate.get();
        orderToUpdateList.getItems().clear();
        orderToUpdateList.getItems().addAll(order.getItems());
        orderToUpdateList.setId(order.getId());
        for(OrderItem oi : orderToUpdateList.getItems()){
            oi.setOrder(orderToUpdateList);
        }
        //orderToUpdateList.setDate(order.getDate());
        orderToUpdateList.setClient(order.getClient());

        orderRepository.save(orderToUpdateList);
        orderItemRepository.saveAll(orderToUpdateList.getItems());
        orderToUpdate = orderRepository.findById(order.getId());

        //orderItemRepository;
        ResponseEntity<?> response;

        if(orderToUpdate.isPresent()) {
            response = new ResponseEntity<>(orderToUpdate, HttpStatus.OK);
        }
        else
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return response;
    }


    //Delete a Order
    @Transactional
    public ResponseEntity<?> remove(Order order) {
        Order orderToDelete = new Order();
        orderToDelete.setId(order.getId());
        Optional<Order> orderToRemove = orderRepository.findById(order.getId());
        ResponseEntity<?> response;

        if(orderToRemove.isPresent()) {
            orderRepository.delete(orderToDelete);
            response = new ResponseEntity<>(HttpStatus.OK);
        }
        else
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return response;
    }


      //Pesquisa por CPF
      public List<Order> findByCPF(String cpf) {

          Client client = clientRepository.findBycpf(cpf);
          Integer id = client.getId();
        
        List<Order> orders = orderRepository.findByclient_id(id);
        
         return orders;

        }

}
