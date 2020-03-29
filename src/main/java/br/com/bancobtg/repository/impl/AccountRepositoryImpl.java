package br.com.bancobtg.repository.impl;

import br.com.bancobtg.db.AccountDB;
import br.com.bancobtg.exceptions.AccountNotFoundException;
import br.com.bancobtg.model.Account;
import br.com.bancobtg.repository.AccountRepository;

import java.math.BigDecimal;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public Account getAccountById(int id) {
        return AccountDB.accounts.stream().filter(account -> account.getId() == id).findFirst().orElseThrow(() -> new AccountNotFoundException("Account not found."));
    }

    @Override
    public void rollback(Account account, BigDecimal amount) {

        try {
            account.cashIn(amount);
        } catch (Exception e) {
            e.printStackTrace();
            rollback(account, amount);
        }

    }

}
