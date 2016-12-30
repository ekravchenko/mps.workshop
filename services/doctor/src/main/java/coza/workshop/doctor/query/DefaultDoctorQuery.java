package coza.workshop.doctor.query;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static coza.workshop.model.tables.Doctor.DOCTOR;

@Repository
public class DefaultDoctorQuery implements DoctorQuery {

    private final DSLContext dsl;

    @Autowired
    public DefaultDoctorQuery(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Doctor> findAll() {
        return dsl.select(DOCTOR.NAME,
                DOCTOR.SURNAME,
                DOCTOR.SPECIALITY).
                from(DOCTOR).fetchInto(Doctor.class);
    }
}
