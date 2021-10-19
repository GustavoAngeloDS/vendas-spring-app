package br.com.vendas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name= "order_id")
    private Order order;

    @JsonIgnore
    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name= "product_id")
    private Product product;

}
