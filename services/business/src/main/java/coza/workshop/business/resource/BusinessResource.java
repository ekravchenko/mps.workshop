package coza.workshop.business.resource;

import coza.workshop.business.query.BusinessQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BusinessResource {

    @Autowired
    private BusinessQuery businessQuery;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/business",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Business>> getAllBusinesses() {
        List<Business> businessList = businessQuery.findAll().stream().map(
                b -> Business.builder()
                        .id(b.getBusinessId())
                        .name(b.getBusinessName())
                        .vatNo(b.getVatNo())
                        .build()).collect(Collectors.toList());

        return new ResponseEntity(businessList, HttpStatus.OK);
    }

}
