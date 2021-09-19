package br.com.vendas.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class OrderDto {


    @NotNull
    private Date data;
    //private Integer idClient;
}

