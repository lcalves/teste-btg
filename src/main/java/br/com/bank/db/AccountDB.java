package br.com.bank.db;

import br.com.bank.model.Account;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountDB {

    private static AtomicInteger sequenceAccountNumber = new AtomicInteger(355040);

    private static AtomicInteger sequenceAccountId = new AtomicInteger(0);
    public static Set<Account> accounts = getAccounts();

    public static Integer getSequenceAccountNumber(int agency) {
        return sequenceAccountNumber.addAndGet(1);
    }

    public static Integer getSequenceAccountId() {
        return sequenceAccountId.addAndGet(1);
    }

    private static Set<Account> getAccounts() {

        if (accounts == null) {

            Account a1 = new Account(2110);
            a1.cashIn(new BigDecimal(20.50));

            Account a2 = new Account(2110);
            a2.cashIn(new BigDecimal(150.00));

            Account a3 = new Account(2111);
            a3.cashIn(new BigDecimal(300.00));

            Account a4 = new Account(2110);

            return new HashSet(Arrays.asList(a1, a2, a3, a4));
        }

        return accounts;

    }

}
