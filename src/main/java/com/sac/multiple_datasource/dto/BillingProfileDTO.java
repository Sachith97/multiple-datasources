package com.sac.multiple_datasource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sachith Rathnasiri
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingProfileDTO {

    private String addressLineOne;
    private String addressLineTwo;
    private String addressLineThree;
}
