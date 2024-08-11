package az.edu.turing.user_profile_application.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = az.edu.turing.user_profile_application.validators.EmailOrPhoneValidator.class)
public @interface EmailOrPhoneRequired {
    String message() default "{Either email or phone number must be provided}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
