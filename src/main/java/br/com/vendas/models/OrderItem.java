package br.com.vendas.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer qtdade;

    @ManyToOne
    @JoinColumn(name= "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name= "product_id")
    private Product product;

}
