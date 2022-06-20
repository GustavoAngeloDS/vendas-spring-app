package br.com.vendas.exceptions;

public class VendasException extends RuntimeException {

    public static final String PRODUCT_IN_ACTIVE_ORDER = "O produto está sendo usado em uma Ordem ativa e não pode ser removido";

    VendasException(String message) {
        super(message);
    }

    VendasException(String message, Throwable cause) {
        super(message, cause);
    }
}
