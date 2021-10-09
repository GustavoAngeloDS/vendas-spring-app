package br.com.vendas.dtos;

import br.com.vendas.models.Client;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class OrderDto {


    @NotNull
    private Date date;

    @NotNull
    private Client client;

}

