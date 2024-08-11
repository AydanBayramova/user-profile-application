package az.edu.turing.user_profile_application.validators;

import az.edu.turing.user_profile_application.annotation.EmailOrPhoneRequired;
import az.edu.turing.user_profile_application.domain.entity.ProfileEntity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailOrPhoneValidator implements ConstraintValidator<EmailOrPhoneRequired, ProfileEntity> {

    @Override
    public boolean isValid(ProfileEntity profileEntity, ConstraintValidatorContext constraintValidatorContext) {
        if (profileEntity == null) {
            return false;
        }
        return profileEntity.getEmail() != null && !profileEntity.getEmail().isEmpty()
                || profileEntity.getPhoneNumber() != null && !profileEntity.getPhoneNumber().isEmpty();
    }
}
