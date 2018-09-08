package io.github.mbarre.ticketrestoncrest.controller;

import io.github.mbarre.ticketrestoncrest.exception.InternalErrorException;
import io.github.mbarre.ticketrestoncrest.model.Partner;
import io.github.mbarre.ticketrestoncrest.service.PartnerService;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping(value = "/partners/pdf", headers = "Accept=*/*", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getAffiliesPdf() {
        try {
            HttpHeaders responseHeaders = new HttpHeaders();
            InputStream is = partnerService.getPartnersPdf();
            InputStreamResource inputStreamResource = new InputStreamResource(is);
            responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
            return new ResponseEntity<InputStreamResource>(inputStreamResource,
                    responseHeaders,
                    HttpStatus.OK);

        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }
}