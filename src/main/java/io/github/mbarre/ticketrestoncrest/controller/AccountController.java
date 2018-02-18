package io.github.mbarre.ticketrestoncrest.controller;

import io.github.mbarre.ticketrestoncrest.exception.InternalErrorException;
import io.github.mbarre.ticketrestoncrest.model.Account;
import io.github.mbarre.ticketrestoncrest.model.Balance;
import io.github.mbarre.ticketrestoncrest.model.Transaction;
import io.github.mbarre.ticketrestoncrest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts/{identifier}/{password}/detail")
    public Account getAccountDetail(@PathVariable String identifier, @PathVariable String password) {
        return accountService.getAccountDetails(identifier,password);
    }

    @GetMapping(value = "/accounts/{identifier}/{password}/balance")
    public Balance getBalance(@PathVariable String identifier, @PathVariable String password) {
        return accountService.getBalance(identifier,password);
    }

    @GetMapping("/accounts/{identifier}/{password}/transactions")
    public List<Transaction> getAllTransactions(@PathVariable String identifier, @PathVariable String password) {
        return accountService.getTransactions(identifier, password,null);
    }

    @GetMapping("/accounts/{identifier}/{password}/transactions/{from}")
    public List<Transaction> getTransactionsSince(@PathVariable String identifier, @PathVariable String password, @PathVariable String from) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        Date fromDate = null;
        try {
            if(!Objects.isNull(from))
                fromDate = formatter.parse(from);
        } catch (ParseException e) {
            throw new InternalErrorException(e.getMessage());
        }
        return accountService.getTransactions(identifier, password,fromDate);
    }



}
