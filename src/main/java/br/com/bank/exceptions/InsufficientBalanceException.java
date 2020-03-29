package br.com.bank.exceptions;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
