package az.edu.turing.user_profile_application.service;

import az.edu.turing.user_profile_application.model.dto.ProfileDto;
import az.edu.turing.user_profile_application.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;




public interface ProfileService {

    ProfileDto addProfile(Long userId,ProfileDto profileDto);

    ProfileDto updateProfile(Long id, ProfileDto profileDto);

    ProfileDto getProfileById(Long userId,Long profileId);

    void deleteProfileById(Long userId, Long profileId);

    Page<ProfileDto> getAllProfiles(Long id,Pageable pageable);

//    void deleteAllProfiles();

}
