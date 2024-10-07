package dev.andrenascimento.twjobs.api.skills.dtos;

import dev.andrenascimento.twjobs.core.validators.SkillsNameIsUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequest {
    
    @NotEmpty
    @SkillsNameIsUnique
    private String name;
}
