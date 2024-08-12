package az.edu.turing.user_profile_application.domain.repository;

import az.edu.turing.user_profile_application.domain.entity.ProfileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    Page<ProfileEntity> findAllByUserId(Long userId, Pageable pageable);
    Optional<ProfileEntity> findByUserIdAndId(Long userId, Long profileId);

}
