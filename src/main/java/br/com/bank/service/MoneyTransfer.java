package br.com.bank.service;

import br.com.bank.exceptions.AccountNotFoundException;
import br.com.bank.exceptions.InsufficientBalanceException;
import br.com.bank.model.Account;
import br.com.bank.repository.AccountRepository;
import br.com.bank.repository.impl.AccountRepositoryImpl;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class MoneyTransfer {

    private final static Logger LOGGER = Logger.getLogger(MoneyTransfer.class);

    private final AccountRepository accountRepository = new AccountRepositoryImpl();

    public boolean transfer(int origemAccountId, int destinyAccountId, double amount)  {

        Account origemAccount;
        final BigDecimal amountOperation = new BigDecimal(amount);
        try {
            origemAccount = accountRepository.getAccountById(origemAccountId);
        } catch (AccountNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
            throw new AccountNotFoundException("Conta de origem não existe.");
        }

        Account destinyAccount;
        try {
            destinyAccount = accountRepository.getAccountById(destinyAccountId);
        } catch (AccountNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
            throw new AccountNotFoundException("Conta destinatário não existe.");
        }

        try {
            origemAccount.cashOut(amountOperation);
        } catch (InsufficientBalanceException e) {
            LOGGER.error(e.getMessage(), e);
            throw new InsufficientBalanceException("Saldo insuficiente.");
        }

        try {
            destinyAccount.cashIn(amountOperation);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            accountRepository.rollback(origemAccount, amountOperation);
            return false;
        }

        return true;

    }

}
