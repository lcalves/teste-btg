package br.com.bancobtg.service;

import br.com.bancobtg.exceptions.AccountNotFoundException;
import br.com.bancobtg.model.Account;
import br.com.bancobtg.repository.AccountRepository;
import br.com.bancobtg.repository.impl.AccountRepositoryImpl;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class MoneyBalance {

    final static Logger logger = Logger.getLogger(MoneyBalance.class);

    private AccountRepository accountRepository = new AccountRepositoryImpl();

    public BigDecimal getBalance(int idAccount) {

        Account account;

        try {
            account = accountRepository.getAccountById(idAccount);
        } catch (AccountNotFoundException e) {
            logger.error(e.getMessage());
            throw new AccountNotFoundException("Conta não localizada") ;
        }

        return account.getBalance();
    }

}
