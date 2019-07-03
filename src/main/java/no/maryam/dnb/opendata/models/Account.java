package no.maryam.dnb.opendata.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties
public class Account {
    List<Balance> balances = new ArrayList<>();

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public void setBalance( Balance balance) {
        this.balances.add(balance);
    }
}
