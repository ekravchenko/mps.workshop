package coza.workshop.security.resource;

import coza.workshop.security.query.BusinessUser;
import coza.workshop.security.query.BusinessUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthResponse auth(@RequestBody AuthRequest request) {
        BusinessUser businessUser = businessUserQuery.findBusinessUser(request.getUsername());

        if (businessUser == null) {
            return new AuthResponse(false, "User not found");
        } else if (!businessUser.getPassword().equals(request.getPassword())) {
            return new AuthResponse(false, "Password not valid");
        }

        return new AuthResponse(true, "");
    }
}
