package io.github.mbarre.ticketrestoncrest.controller;

import io.github.mbarre.ticketrestoncrest.model.Account;
import io.github.mbarre.ticketrestoncrest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts/{identifier}/{password}/detail")
    public Account getAccountDetail(@PathVariable String identifier, @PathVariable String password) {
        return accountService.getAccountDetails(identifier,password);
    }

    @GetMapping("/accounts/{identifier}/{password}/balance")
    public Integer getBalance(@PathVariable String identifier, @PathVariable String password) {
        return accountService.getBalance(identifier,password);
    }

}
