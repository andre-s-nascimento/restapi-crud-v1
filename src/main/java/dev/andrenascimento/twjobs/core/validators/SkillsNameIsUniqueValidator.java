package dev.andrenascimento.twjobs.core.validators;

import org.springframework.stereotype.Component;

import dev.andrenascimento.twjobs.core.repositories.SkillRepository;
import dev.andrenascimento.twjobs.core.services.http.HttpService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SkillsNameIsUniqueValidator implements ConstraintValidator<SkillsNameIsUnique, String> {

    private final SkillRepository skillRepository;
    private final HttpService httpService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        var id = httpService.getPathVariable("id", Long.class);

        if (id.isEmpty()){
            return !skillRepository.existsByName(value);
        }

        return !skillRepository.existsByNameAndIdNot(value, id.get());
    }


    
}
