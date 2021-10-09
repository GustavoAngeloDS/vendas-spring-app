package br.com.vendas.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name= "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name= "product_id")
    private Product product;
}
