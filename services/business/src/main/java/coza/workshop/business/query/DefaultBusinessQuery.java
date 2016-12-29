package coza.workshop.business.query;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static coza.workshop.model.tables.Business.BUSINESS;

@Repository
public class DefaultBusinessQuery implements BusinessQuery {

    private DSLContext dsl;

    @Autowired
    public DefaultBusinessQuery(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<BusinessResult> findAll() {
        return dsl.select(
                BUSINESS.BUSINESSID,
                BUSINESS.BUSINESSNAME,
                BUSINESS.COMPANYREGNO,
                BUSINESS.VATNO)
                .from(BUSINESS)
                .fetchInto(BusinessResult.class);
    }
}
