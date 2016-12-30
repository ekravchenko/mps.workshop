package coza.workshop.business.resource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Business {

    private Integer id;
    private String name;
    private String vatNo;

}
