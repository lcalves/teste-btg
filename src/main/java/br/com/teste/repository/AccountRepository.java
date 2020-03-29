package br.com.teste.repository;

import br.com.teste.model.Account;

import java.math.BigDecimal;

public interface AccountRepository {

    Account getAccountById(int id);
    void rollback(Account account, BigDecimal amount);

}
