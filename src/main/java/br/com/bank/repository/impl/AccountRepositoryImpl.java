package br.com.bank.repository.impl;

import br.com.bank.db.AccountDB;
import br.com.bank.exceptions.AccountNotFoundException;
import br.com.bank.model.Account;
import br.com.bank.repository.AccountRepository;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class AccountRepositoryImpl implements AccountRepository {


    private final static Logger LOGGER = Logger.getLogger(AccountRepositoryImpl.class);

    @Override
    public Account getAccountById(int id) {
        return AccountDB.accounts.stream().filter(account -> account.getId() == id).findFirst().orElseThrow(() -> new AccountNotFoundException("Account not found."));
    }

    @Override
    public void rollback(Account account, BigDecimal amount) {

        try {
            account.cashIn(amount);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

}
