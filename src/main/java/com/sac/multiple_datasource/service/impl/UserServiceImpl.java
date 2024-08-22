package com.sac.multiple_datasource.service.impl;

import com.sac.multiple_datasource.dto.BillingProfileDTO;
import com.sac.multiple_datasource.dto.UserBillingProfileDTO;
import com.sac.multiple_datasource.model.primary.User;
import com.sac.multiple_datasource.model.secondary.BillingProfile;
import com.sac.multiple_datasource.repo.primary.UserRepository;
import com.sac.multiple_datasource.repo.secondary.BillingProfileRepository;
import com.sac.multiple_datasource.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sachith Rathnasiri
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BillingProfileRepository billingProfileRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BillingProfileRepository billingProfileRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.billingProfileRepository = billingProfileRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserBillingProfileDTO> findUserBillingProfile() {
        List<UserBillingProfileDTO> userBillingProfileList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            List<BillingProfile> profileList = billingProfileRepository.findAllByUserEmpIdAndStatus(user.getEmpId(), "Active");
            UserBillingProfileDTO profile = UserBillingProfileDTO.builder()
                    .userName(user.getFirstName() + " " + user.getLastName())
                    .empId(user.getEmpId())
                    .billingProfileList(modelMapper.map(profileList, new TypeToken<List<BillingProfileDTO>>() {}.getType()))
                    .build();
            userBillingProfileList.add(profile);
        });
        return userBillingProfileList;
    }
}
