package com.sac.multiple_datasource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Sachith Rathnasiri
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBillingProfileDTO {

    private String userName;
    private String empId;
    private List<BillingProfileDTO> billingProfileList;
}
