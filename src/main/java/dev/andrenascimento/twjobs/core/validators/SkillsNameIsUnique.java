package dev.andrenascimento.twjobs.core.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = { SkillsNameIsUniqueValidator.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SkillsNameIsUnique {
    
    String message() default "this ${validatedValue} skill name is already in use";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
    
}
