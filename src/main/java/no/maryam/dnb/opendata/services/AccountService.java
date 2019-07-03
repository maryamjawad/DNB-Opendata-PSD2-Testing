package no.maryam.dnb.opendata.services;

import no.maryam.dnb.opendata.models.Account;
import org.springframework.stereotype.Service;

//@Service
public interface AccountService {
    Account getAccount(String personalNumber);
}
