package io.github.mbarre.ticketrestoncrest.controller;

import io.github.mbarre.ticketrestoncrest.exception.InternalErrorException;
import io.github.mbarre.ticketrestoncrest.model.Partner;
import io.github.mbarre.ticketrestoncrest.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping("/partners")
    public List<Partner> getAllPartners() {
        try {
            return partnerService.getAllPartners();
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }
}
