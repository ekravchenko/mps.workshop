package coza.workshop.business.resource;

import coza.workshop.business.query.BusinessQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BusinessResource {

    private static final Logger log = LoggerFactory.getLogger(BusinessResource.class);

    @Autowired
    private BusinessQuery businessQuery;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/business",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Business> getAllBusinesses() {
        log.debug("Started getting all businesses");

        List<Business> businessList = businessQuery.findAll().stream().map(
                b -> Business.builder()
                        .id(b.getBusinessId())
                        .name(b.getBusinessName())
                        .vatNo(b.getVatNo())
                        .build()).collect(Collectors.toList());
        log.info("Found {} business(es)", businessList.size());

        log.debug("Completed getting all businesses");
        return businessList;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/generateException",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Business> generateException() {
        throw new RuntimeException("Business exception");
    }

}
