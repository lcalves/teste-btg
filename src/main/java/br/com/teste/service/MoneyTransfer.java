package br.com.teste.service;

import br.com.teste.exceptions.AccountNotFoundException;
import br.com.teste.exceptions.InsufficientBalanceException;
import br.com.teste.model.Account;
import br.com.teste.repository.AccountRepository;
import br.com.teste.repository.impl.AccountRepositoryImpl;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class MoneyTransfer {

    final static Logger logger = Logger.getLogger(MoneyTransfer.class);

    private AccountRepository accountRepository = new AccountRepositoryImpl();

    public boolean transfer(int origemAccountId, int destinyAccountId, double amount)  {

        Account origemAccount;
        final BigDecimal amountOperation = new BigDecimal(amount);
        try {
            origemAccount = accountRepository.getAccountById(origemAccountId);
        } catch (AccountNotFoundException e) {
            logger.error(e.getMessage());
            throw new AccountNotFoundException("Conta de origem não existe.");

        }

        Account destinyAccount;
        try {
            destinyAccount = accountRepository.getAccountById(destinyAccountId);
        } catch (AccountNotFoundException e) {
            logger.error(e.getMessage());
            throw new AccountNotFoundException("Conta destinatário não existe.");
        }

        try {
            origemAccount.cashOut(amountOperation);
        } catch (InsufficientBalanceException e) {
            logger.error(e.getMessage());
            throw new InsufficientBalanceException("Saldo insuficiente.");
        }

        try {

            destinyAccount.cashIn(amountOperation);
        } catch (Exception e) {
            logger.error(e.getMessage());
            accountRepository.rollback(origemAccount, amountOperation);
            return false;
        }

        return true;

    }

}
