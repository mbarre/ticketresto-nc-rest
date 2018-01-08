package io.github.mbarre.ticketrestoncrest.service;

import com.github.adriens.tickets.resto.nc.api.ServiceType;
import com.github.adriens.tickets.resto.nc.api.TicketsRestaurantsServiceWrapper;
import io.github.mbarre.ticketrestoncrest.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);
    private TicketsRestaurantsServiceWrapper wrap;

    public Account getAccountDetails(String identifier, String password) {

        Account account = null;

        try {
            wrap = new TicketsRestaurantsServiceWrapper(identifier, password, ServiceType.SOLDE);

            if (!Objects.isNull(wrap)) {
                account = new Account();
                account.setFullName(wrap.getAccountName());
                account.setEmployer(wrap.getAccountEmployeer());
                account.setBalance(wrap.getAccountBalance());
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
        finally {
            return account;
        }

    }

    public Integer getBalance(String identifier, String password) {

        Integer balance = null;

        try {
            wrap = new TicketsRestaurantsServiceWrapper(identifier, password, ServiceType.SOLDE);

            if (!Objects.isNull(wrap)) {
                balance = wrap.getAccountBalance();
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
        finally {
            return balance;
        }

    }
}
