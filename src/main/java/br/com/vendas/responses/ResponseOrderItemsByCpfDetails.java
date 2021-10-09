package br.com.vendas.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseOrderItemsByCpfDetails {
	Integer quantity;
	String description;
}
