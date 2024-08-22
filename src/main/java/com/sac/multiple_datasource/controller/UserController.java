package com.sac.multiple_datasource.controller;

import com.sac.multiple_datasource.exception.Response;
import com.sac.multiple_datasource.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sachith Rathnasiri
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-billing-profiles")
    public ResponseEntity<Object> getUserBillingProfile() {
        try {
            return ResponseEntity.ok().body(userService.findUserBillingProfile());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Response response = Response.builder()
                    .responseCode("500")
                    .responseDescription("Exception occurred: " + e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
