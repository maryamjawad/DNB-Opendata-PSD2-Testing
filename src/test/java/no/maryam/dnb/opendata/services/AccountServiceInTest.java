package no.maryam.dnb.opendata.services;

import no.maryam.dnb.opendata.models.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AccountServiceInTest {

    //@Autowired
    AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

    @Test
    void testThatAccountHas2000Balace(){
        Account acc = accountServiceImpl.getAccount("0404930000");
        String am = acc.getBalances().get(0).getBalanceAmount().getAmount();
        Assertions.assertEquals("2000", am);
    }


    @Test
    void testThatAccountHasNOKCurrencyType(){
        Account acc = accountServiceImpl.getAccount("0404930000");
        String ct = acc.getBalances().get(0).getBalanceAmount().getCurrency();
        Assertions.assertEquals("NOK", ct);
    }

    @Test
    void testThatAccountIsNull(){
        Account acc = accountServiceImpl.getAccount("0404930000");
        Assertions.assertNotEquals(acc,null);
    }

}