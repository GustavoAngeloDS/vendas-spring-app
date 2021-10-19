package br.com.vendas.dtos;

import br.com.vendas.models.Order;
import br.com.vendas.models.Product;
import lombok.Data;

@Data
public class OrderItemDto {

    private Integer qtdade;

    private Order order;

    private Product product;

}

