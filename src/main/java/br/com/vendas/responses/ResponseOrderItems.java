package br.com.vendas.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseOrderItems {
	@JsonIgnore
	Integer orderId;
	Integer productId;
	Integer quantity;
	String description;
}
