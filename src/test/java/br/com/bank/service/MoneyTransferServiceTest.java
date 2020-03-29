package br.com.bank.service;

import br.com.bank.db.AccountDB;
import br.com.bank.exceptions.AccountNotFoundException;
import br.com.bank.exceptions.InsufficientBalanceException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import templates.Templates;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;

@RunWith(MockitoJUnitRunner.class)
public class MoneyTransferServiceTest {

    private MoneyTransferService moneyTransferService = new MoneyTransferService();

    @BeforeClass
    public static void before() {
        loadTemplates(Templates.BASE_PACKAGE);
    }

    @Mock
    private AccountDB db;

    @Test
    public void validTransferTest() {

        boolean transferred = moneyTransferService.transfer(3, 2, 20);

        Assert.assertTrue(transferred);

    }

    @Test(expected = AccountNotFoundException.class)
    public void transferOrigemAccountNotFounTest() {

        moneyTransferService.transfer(5, 2, 20);

    }

    @Test(expected = AccountNotFoundException.class)
    public void transferDestinyAccountNotFounTest() {

        moneyTransferService.transfer(1, 5, 20);

    }

    @Test(expected = InsufficientBalanceException.class)
    public void transferInsufficientBalanceTest() {

        moneyTransferService.transfer(1, 2, 120);

    }

}