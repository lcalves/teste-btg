package br.com.bank.model;

import br.com.bank.db.AccountDB;
import br.com.bank.exceptions.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private Integer id;
    private int agency;
    private int accountNumber;
    private BigDecimal balance;
    private AccountSituation accountSituation;

    public Account(int agency) {
        this.id = AccountDB.getSequenceAccountId();
        this.agency = agency;
        this.accountNumber = AccountDB.getSequenceAccountNumber(agency);
        this.balance = new BigDecimal(0.00);
        this.accountSituation = AccountSituation.ACTIVE;

    }

    public void cashIn(BigDecimal value) {

        this.balance = this.balance.add(value);

    }

    public void cashOut(BigDecimal value) throws InsufficientBalanceException {

        if (hasBalanceForOperation(value)) {
            this.balance = this.balance.subtract(value);
        } else {
            throw new InsufficientBalanceException("Customer has no balance for this operation.");
        }

    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    private boolean hasBalanceForOperation(BigDecimal value) {

        if (this.balance.compareTo(value) == -1) {
            return false;
        }

        return true;

    }

    public void changeAccountSituation(AccountSituation accountSituation) {
        this.accountSituation = accountSituation;
    }

    public int getId() {
        return id;
    }

    public AccountSituation getAccountSituation() {
        return accountSituation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return agency == account.agency &&
                accountNumber == account.accountNumber &&
                Objects.equals(id, account.id) &&
                Objects.equals(balance, account.balance) &&
                accountSituation == account.accountSituation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agency, accountNumber, balance, accountSituation);
    }
}
