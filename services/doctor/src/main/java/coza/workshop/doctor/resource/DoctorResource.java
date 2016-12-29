package coza.workshop.doctor.resource;

import coza.workshop.doctor.query.DoctorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorResource {
    private final DoctorQuery doctorQuery;

    @Autowired
    public DoctorResource(DoctorQuery doctorQuery) {
        this.doctorQuery = doctorQuery;
    }

    @RequestMapping(method = RequestMethod.GET,
            path="/doctors",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<coza.workshop.doctor.query.Doctor> getDoctors(){
        return doctorQuery.findAll();
    }
}
