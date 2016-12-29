package coza.workshop.security.resource;

import coza.workshop.security.query.BusinessUser;
import coza.workshop.security.query.BusinessUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SecurityResource {

    private final BusinessUserQuery businessUserQuery;

    @Autowired
    public SecurityResource(BusinessUserQuery businessUserQuery) {
        this.businessUserQuery = businessUserQuery;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/auth",
            produces = MediaType.TEXT_PLAIN_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> auth(@RequestBody AuthRequest request) {
        BusinessUser businessUser = businessUserQuery.findBusinessUser(request.getUsername());

        if (businessUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        } else if (!businessUser.getPassword().equals(request.getPassword())) {
            return new ResponseEntity<>("Password not valid", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(UUID.randomUUID().toString(), HttpStatus.OK);
    }
}
