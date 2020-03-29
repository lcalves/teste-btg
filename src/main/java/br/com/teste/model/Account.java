package br.com.teste.model;

import br.com.teste.db.AccountDB;
import br.com.teste.exceptions.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private Integer id;
    private int agency;
    private int accountNumber;
    private BigDecimal balance;

    public Account(int agency) {
        this.id = AccountDB.getSequenceAccountId();
        this.agency = agency;
        this.accountNumber = AccountDB.getSequenceAccountNumber(agency);
        this.balance = new BigDecimal(0.00);

    }

    public void cashIn(BigDecimal value) {

        this.balance = this.balance.add(value);

    }

    /**
     * Metodo que realiza a retirada de valor do saldo da conta
     * @param value - valor a ser retirado da conta
     *     *
     * @throws InsufficientBalanceException - lancado caso a conta nao tenha saldo suficiente para transacao
     */
    public void cashOut(BigDecimal value) throws InsufficientBalanceException {

        if (hasBalanceForOperation(value)) {
            this.balance = this.balance.subtract(value);
        } else {
            throw new InsufficientBalanceException("Customer has no balance for this operation.");
        }

    }

    public BigDecimal getBalance() {
        return new BigDecimal(this.balance.doubleValue());
    }

    private boolean hasBalanceForOperation(BigDecimal value) {

        if (this.balance.compareTo(value) == -1) {
            return false;
        }

        return true;

    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
