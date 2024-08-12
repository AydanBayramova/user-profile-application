package com.boot.bff.controller;

import az.edu.turing.user_profile_application.model.dto.ProfileDto;
import com.boot.bff.service.BffUserProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bff/users")
public class BffUserProfileController {

    private final BffUserProfileService userProfileService;

    public BffUserProfileController(BffUserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/{userId}/profiles")
    public ProfileDto getUserProfile(@PathVariable Long userId) {
        return userProfileService.getUserProfile(userId);
    }
}
