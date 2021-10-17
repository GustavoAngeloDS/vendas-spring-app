package br.com.vendas.responses;

import lombok.*;

@Data
@Builder
public class ErrorResponse {
    String message;
}
