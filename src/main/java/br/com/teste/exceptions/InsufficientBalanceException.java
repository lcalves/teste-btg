package br.com.teste.exceptions;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException() {
    }

    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
