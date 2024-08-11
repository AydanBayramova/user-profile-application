package az.edu.turing.user_profile_application.model.dto;

import az.edu.turing.user_profile_application.domain.enums.Gender;
import az.edu.turing.user_profile_application.domain.enums.Status;
import az.edu.turing.user_profile_application.domain.enums.Visibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private Long id;
    private String username;
    private String address;
    private String phoneNumber;
    private String email;
    private String bio;
    private Status status;
    private Gender gender;
    private String image;
    private Long userId;
    private String userUsername;

    private LocalDateTime lastSeen;

    private Visibility lastSeenVisibility;

    private Visibility imageVisibility;
}
