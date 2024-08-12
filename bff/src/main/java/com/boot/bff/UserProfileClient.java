package com.boot.bff;

import az.edu.turing.user_profile_application.model.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserProfileClient {
    private final RestTemplate restTemplate;

    @Value("${user-profile.url}")
    private String userProfileBaseUrl;

    public UserProfileClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProfileDto getUserProfileById(Long userId) {
        String url = userProfileBaseUrl + "/api/users/" + userId + "/profiles";
        return restTemplate.getForObject(url, ProfileDto.class);
    }
}
