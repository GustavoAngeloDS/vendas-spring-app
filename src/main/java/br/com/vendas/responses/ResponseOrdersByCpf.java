package br.com.vendas.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrdersByCpf {
	Integer orderId;
	List<ResponseOrderItems> orderItemsList; 
}
 