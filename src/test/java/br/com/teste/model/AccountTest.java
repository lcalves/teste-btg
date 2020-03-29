package br.com.teste.model;

import br.com.teste.exceptions.InsufficientBalanceException;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import templates.Templates;

import java.math.BigDecimal;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static templates.AccountTemplate.VALID_ACCOUNT_MODEL;

public class AccountTest {

    @BeforeClass
    public static void before() {
        loadTemplates(Templates.BASE_PACKAGE);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void cashOutInsufficientBalanceTest() {
        Account account = Fixture.from(Account.class).gimme(VALID_ACCOUNT_MODEL);

        account.cashOut(new BigDecimal(120));

    }

    @Test
    public void cashOutValidTest() {
        Account account = Fixture.from(Account.class).gimme(VALID_ACCOUNT_MODEL);

        account.cashOut(new BigDecimal(50));

        Assert.assertEquals(new BigDecimal(50), account.getBalance());

    }
}