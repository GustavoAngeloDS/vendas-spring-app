package br.com.vendas.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="order_items")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    @EqualsAndHashCode.Include
    private OrderItemPK id = new OrderItemPK();

    private Integer qtdade;


    public OrderItem(Order order, Product product, Integer qtdade) {
        id.setOrder(order);
        id.setProduct(product);
        this.qtdade = qtdade;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    //@JsonIgnore
    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    //    @Id
//    @Getter
//    @Setter
//    @EqualsAndHashCode.Include
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @JsonIgnore
//    @ManyToOne
//    @Getter
//    @Setter
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @JsonIgnore
//    @ManyToOne
//    @Getter
//    @Setter
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//
//    private Integer qtdade;
}
