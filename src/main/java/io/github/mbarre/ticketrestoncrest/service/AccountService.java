package io.github.mbarre.ticketrestoncrest.service;

import com.github.adriens.tickets.resto.nc.api.ServiceType;
import com.github.adriens.tickets.resto.nc.api.TicketsRestaurantsServiceWrapper;
import io.github.mbarre.ticketrestoncrest.exception.InternalErrorException;
import io.github.mbarre.ticketrestoncrest.exception.ResourceNotFoundException;
import io.github.mbarre.ticketrestoncrest.model.Account;
import io.github.mbarre.ticketrestoncrest.model.Balance;
import io.github.mbarre.ticketrestoncrest.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public Balance getBalance(String identifier, String password) {

        try {
            wrap = new TicketsRestaurantsServiceWrapper(identifier, password, ServiceType.SOLDE);

            if (!Objects.isNull(wrap)) {
                return new Balance(wrap.getAccountBalance());
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

    public List<Transaction> getTransactions(String identifier, String password, Date from) {

        try {
            wrap = new TicketsRestaurantsServiceWrapper(identifier, password, ServiceType.BOTH);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");


            List<Transaction> transactions = new ArrayList<>();
            if (!Objects.isNull(wrap)) {
                for (com.github.adriens.tickets.resto.nc.api.Transaction trans : wrap.getTransactions()) {

                    if(Objects.isNull(from) || trans.getDate().after(from) || trans.getDate().equals(from)) {
                        Transaction transaction = new Transaction();
                        if (trans.getCredit() > 0)
                            transaction.setAmount(trans.getCredit());
                        else
                            transaction.setAmount(-trans.getDebit());
                        transaction.setDate(df.format(trans.getDate()));
                        transaction.setDescription(trans.getLibelle());

                        transactions.add(transaction);
                    }

                }
                log.error("transactions"+transactions);
                return transactions;
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
                log.error(e.getMessage());
                throw new InternalErrorException(e.getMessage());
        }

    }

}
