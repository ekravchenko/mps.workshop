package coza.workshop.business.query;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
public class BusinessResult {

    private Integer businessId;
    private String businessName;
    private String vatNo;
    private String companyRegNo;

}
