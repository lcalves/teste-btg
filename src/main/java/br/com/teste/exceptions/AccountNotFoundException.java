package br.com.teste.exceptions;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String msg) {

        super(msg);

    }
}
