package br.com.vendas.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClientDto {

    @NotEmpty
    @NotNull
    private String cpf;

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String lastname;
}
