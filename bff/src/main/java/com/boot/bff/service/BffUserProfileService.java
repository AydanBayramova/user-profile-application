package com.boot.bff.service;

import az.edu.turing.user_profile_application.model.dto.ProfileDto;
import com.boot.bff.UserProfileClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class BffUserProfileService {

    private final UserProfileClient userProfileClient;

    public BffUserProfileService(UserProfileClient userProfileClient) {
        this.userProfileClient = userProfileClient;
    }

    public ProfileDto getUserProfile(Long userId) {
        return userProfileClient.getUserProfileById(userId);
    }
}
