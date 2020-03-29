package br.com.bank.repository;

import br.com.bank.model.Account;

import java.math.BigDecimal;

public interface AccountRepository {

    Account getAccountById(int id);
    void rollback(Account account, BigDecimal amount);

}
