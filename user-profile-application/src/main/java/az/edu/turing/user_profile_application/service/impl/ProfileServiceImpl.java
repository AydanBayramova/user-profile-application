package az.edu.turing.user_profile_application.service.impl;

import az.edu.turing.user_profile_application.domain.entity.ProfileEntity;
import az.edu.turing.user_profile_application.domain.entity.UserEntity;
import az.edu.turing.user_profile_application.domain.repository.ProfileRepository;
import az.edu.turing.user_profile_application.domain.repository.UserRepository;
import az.edu.turing.user_profile_application.model.dto.ProfileDto;
import az.edu.turing.user_profile_application.model.mapper.ProfileMapper;
import az.edu.turing.user_profile_application.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final UserRepository userRepository;


    @Override
    public ProfileDto addProfile(Long userId, ProfileDto profileDto) {
        UserEntity user = userRepository.findById(userId).
                orElseThrow(() -> new RuntimeException("user not found"));
        if (user.getAge() < 18) {
            throw new IllegalArgumentException("Age must be 18");
        }
        ProfileEntity profileEntity = profileMapper.toprofileEntity(profileDto);
        profileEntity.setUser(user);
        profileRepository.save(profileEntity);
        return profileMapper.toprofileDto(profileEntity);
    }

    @Override
    public ProfileDto updateProfile(Long id, ProfileDto profileDto) {
        Optional<ProfileEntity> byId = profileRepository.findById(id);
        if (byId.isPresent()) {
            return profileMapper.toprofileDto(profileRepository.save(profileMapper.toprofileEntity(profileDto)));
        } else {
            throw new RuntimeException("profile not found");
        }

    }

    @Override
    public ProfileDto getProfileById(Long id) {
        return profileMapper.toprofileDto(profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found")));
    }

    @Override
    public void deleteProfileById(Long id) {
        ProfileEntity profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        profileRepository.delete(profile);
    }

    @Override
    public Page<ProfileDto> getAllProfiles(Pageable pageable) {
        return profileRepository.findAll(pageable).map(profileMapper::toprofileDto);
    }


    @Override
    public void deleteAllProfiles() {
        profileRepository.deleteAll();
    }
}
