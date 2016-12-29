package coza.workshop.security.query;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static coza.workshop.model.tables.BusinessUser.*;

@Repository
public class DefaultBusinessUserQuery implements BusinessUserQuery {

    private final DSLContext dsl;

    @Autowired
    public DefaultBusinessUserQuery(DSLContext dsl) {
        this.dsl = dsl;
    }

    public BusinessUser findBusinessUser(String username) {
        return dsl
                .select(BUSINESS_USER.USERNAME,
                        BUSINESS_USER.PASSWORD)
                .from(BUSINESS_USER)
                .where(BUSINESS_USER.USERNAME.eq(username))
                .fetchOneInto(BusinessUser.class);
    }
}
