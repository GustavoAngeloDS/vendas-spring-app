package br.com.vendas.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductDto {

	@NotEmpty @NotNull 
	private String description;
}
