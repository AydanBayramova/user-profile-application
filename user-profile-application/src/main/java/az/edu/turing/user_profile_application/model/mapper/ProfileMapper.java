package az.edu.turing.user_profile_application.model.mapper;


import az.edu.turing.user_profile_application.domain.entity.ProfileEntity;
import az.edu.turing.user_profile_application.model.dto.ProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileEntity  toprofileEntity(ProfileDto profileDto);
    ProfileDto toprofileDto(ProfileEntity profileEntity);
    void updateProfileEntityFromDto(ProfileDto profileDto, @MappingTarget ProfileEntity profileEntity);
}
