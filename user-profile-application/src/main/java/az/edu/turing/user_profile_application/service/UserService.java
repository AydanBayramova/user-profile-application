package az.edu.turing.user_profile_application.service;





import az.edu.turing.user_profile_application.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface UserService {

    UserDto save(UserDto userDto);

    public Page<UserDto> getAll(Pageable pageable);

    Optional<UserDto> getById(Long id);

    void deleteAll();

    void deleteById(Long id);

    UserDto update(Long id, UserDto userDto);
}
