package coza.workshop.doctor.resource;

import coza.workshop.doctor.query.Doctor;
import coza.workshop.doctor.query.DoctorQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorResource {

    private static final Logger log = LoggerFactory.getLogger(DoctorResource.class);

    private final DoctorQuery doctorQuery;

    @Autowired
    public DoctorResource(DoctorQuery doctorQuery) {
        this.doctorQuery = doctorQuery;
    }

    @RequestMapping(method = RequestMethod.GET,
            path="/doctors",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Doctor> getDoctors(){
        log.debug("Started getting all doctors");

        List<Doctor> doctors = doctorQuery.findAll();
        log.info("Found {} doctors", doctors.size());

        log.debug("Completed getting all doctors");
        return doctors;
    }
}
