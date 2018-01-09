package io.github.mbarre.ticketrestoncrest.service;

import com.github.adriens.tickets.resto.nc.api.ServiceType;
import com.github.adriens.tickets.resto.nc.api.TicketsRestaurantsServiceWrapper;
import io.github.mbarre.ticketrestoncrest.exception.InternalErrorException;
import io.github.mbarre.ticketrestoncrest.exception.ResourceNotFoundException;
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

            if (!Objects.isNull(wrap) && !Objects.isNull(wrap.getAccountName())) {
                account = new Account();
                account.setFullName(wrap.getAccountName());
                account.setEmployer(wrap.getAccountEmployeer());
                account.setBalance(wrap.getAccountBalance());
                return account;
            }
            else {
                log.error("TicketsRestaurantsServiceWrapper is null");
                throw new ResourceNotFoundException(identifier, "Account not found, bad identifier or password.");
            }

        }catch (Exception e){
            log.error(e.getMessage());
            if(Objects.equals("Cet utilisateur n'existe pas", e.getMessage()))
                throw new ResourceNotFoundException(identifier, "Account not found, bad identifier or password.");
            else
                throw new InternalErrorException(e.getMessage());
        }
    }

    public Integer getBalance(String identifier, String password) {

        try {
            wrap = new TicketsRestaurantsServiceWrapper(identifier, password, ServiceType.SOLDE);

            if (!Objects.isNull(wrap)) {
                return wrap.getAccountBalance();

            }
            else {
                log.error("TicketsRestaurantsServiceWrapper is null");
                throw new ResourceNotFoundException(identifier, "Account not found, bad identifier or password.");
            }

        }catch (Exception e){
            log.error(e.getMessage());
            if(Objects.equals("Cet utilisateur n'existe pas", e.getMessage()))
                throw new ResourceNotFoundException(identifier, "Account not found, bad identifier or password.");
            else
                throw new InternalErrorException(e.getMessage());
        }

    }
}
