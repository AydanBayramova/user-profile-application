package az.edu.turing.user_profile_application.domain.entity;

import az.edu.turing.user_profile_application.annotation.EmailOrPhoneRequired;
import az.edu.turing.user_profile_application.domain.enums.Gender;
import az.edu.turing.user_profile_application.domain.enums.Status;
import az.edu.turing.user_profile_application.domain.enums.Visibility;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@EmailOrPhoneRequired
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String username;

    @Column(length = 100)
    private String address;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
    @Column(length = 15)
    private String phoneNumber;

    @Email(message = "Invalid email address")
    @Column(length = 100)
    private String email;

    @Lob
    @Column(length = 100, columnDefinition = "TEXT")
    private String bio;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "last_seen_visibility", nullable = false)
    private Visibility lastSeenVisibility = Visibility.PUBLIC;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length =10)
    private Gender gender;

    @Lob
    @Column(name = "profile_image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "last_seen", nullable = false)
    private LocalDateTime lastSeen = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "image_visibility", nullable = false)
    private Visibility imageVisibility = Visibility.PUBLIC;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
