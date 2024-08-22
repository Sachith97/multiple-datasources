package com.sac.multiple_datasource.service;

import com.sac.multiple_datasource.dto.UserBillingProfileDTO;

import java.util.List;

/**
 * @author Sachith Rathnasiri
 */
public interface UserService {

    List<UserBillingProfileDTO> findUserBillingProfile();
}
