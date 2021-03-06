package br.com.bank.model;

import br.com.bank.exceptions.InsufficientBalanceException;
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

    @Test(expected =InsufficientBalanceException.class )
    public void cashOutInsufficientBalanceTest(){
        Account account = Fixture.from(Account.class).gimme(VALID_ACCOUNT_MODEL);

        account.cashOut(new BigDecimal(120));

    }

    @Test
    public void cashOutValidTest(){
        Account account = Fixture.from(Account.class).gimme(VALID_ACCOUNT_MODEL);

        account.cashOut(new BigDecimal(100));

        Assert.assertEquals(new BigDecimal(0), account.getBalance());

    }
}