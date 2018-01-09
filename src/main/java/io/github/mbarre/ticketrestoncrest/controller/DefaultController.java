package io.github.mbarre.ticketrestoncrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String getServiceInfo(){
        return "This service aim to allow \"Ticket Restaurant Nouvelle Calédonie\" users to get their account detail. \nFor more information on how to use this service, please see our page : https://github.com/mbarre/ticketresto-nc-rest";
    }

}
