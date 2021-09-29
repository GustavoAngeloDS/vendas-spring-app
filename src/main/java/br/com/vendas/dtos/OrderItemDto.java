package br.com.vendas.dtos;

import br.com.vendas.models.Client;
import br.com.vendas.models.Order;
import br.com.vendas.models.Product;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class OrderItemDto {

    private Integer qtdade;

    private Order order;

    private Product product;

}

