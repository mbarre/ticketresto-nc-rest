package io.github.mbarre.ticketrestoncrest.service;

import com.github.adriens.tickets.resto.nc.api.Affilie;
import com.github.adriens.tickets.resto.nc.api.TicketsRestaurantsServiceWrapper;
import io.github.mbarre.ticketrestoncrest.model.Partner;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);
    private TicketsRestaurantsServiceWrapper wrap;

    public List<Partner> getAllPartners() throws Exception {

        List<Partner> allPartners = new ArrayList<>();
            List<Affilie> affilieList = TicketsRestaurantsServiceWrapper.getAffilies();
            Partner newPartner;
            for (Affilie affilie : affilieList) {
                newPartner = new Partner();
                newPartner.setName(affilie.getEnseigne());
                if(affilie.getCategorie() != null && !affilie.getCategorie().isEmpty())
                    newPartner.setCategory(StringUtils.capitalize(affilie.getCategorie().toLowerCase()));
                if(affilie.getCuisine() != null && !affilie.getCuisine().isEmpty())
                    newPartner.setFoodType(StringUtils.capitalize(affilie.getCuisine().toLowerCase()));
                newPartner.setAddress(affilie.getFormattedAdress());
                newPartner.setDistrict(affilie.getQuartier());
                newPartner.setCity(affilie.getCommune());
                newPartner.setPhone(Affilie.getFormattedTelephoneNumber(affilie.getTelephone()));
                newPartner.setGoogleMapsUrl(Affilie.getGmapsURL(newPartner.getName()));
                allPartners.add(newPartner);
            }

        return allPartners;
    }
}
