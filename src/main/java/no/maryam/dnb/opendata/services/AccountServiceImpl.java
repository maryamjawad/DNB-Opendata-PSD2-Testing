package no.maryam.dnb.opendata.services;

import no.maryam.dnb.opendata.models.Account;
import no.maryam.dnb.opendata.models.Balance;
import no.maryam.dnb.opendata.models.BalanceAmount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AccountServiceImpl{

    public Account getAccount(String personalNumber){
        BalanceAmount amount = new BalanceAmount();
        amount.setAmount("2000");
        amount.setCurrency("NOK");

        Balance balance = new Balance();
        balance.setBalanceAmount(amount);

        List<Balance> balances = new ArrayList<>();
        balances.add(balance);

        Account account = new Account();
        account.setBalances(balances);

        return account;
    }
}
