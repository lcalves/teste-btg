package br.com.bank.exceptions;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String msg) {

        super(msg);

    }
}
