package az.edu.turing.user_profile_application.model.mapper;



import az.edu.turing.user_profile_application.domain.entity.UserEntity;
import az.edu.turing.user_profile_application.model.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;



@Mapper(componentModel = "spring")
public interface UserMapper {
     UserDto toUserDto(UserEntity user);

     UserEntity toUserEntity(UserDto userDto);

}
