package no.maryam.dnb.opendata.services;

import no.maryam.dnb.opendata.models.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public Account getAccount(){
        return new Account();

    }
}
