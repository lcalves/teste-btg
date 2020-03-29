package br.com.bancobtg.repository;

import br.com.bancobtg.model.Account;

import java.math.BigDecimal;

public interface AccountRepository {

    Account getAccountById(int id);
    void rollback(Account account, BigDecimal amount);

}
