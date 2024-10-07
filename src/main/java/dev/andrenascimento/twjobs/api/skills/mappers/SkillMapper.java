package dev.andrenascimento.twjobs.api.skills.mappers;

import dev.andrenascimento.twjobs.api.skills.dtos.SkillRequest;
import dev.andrenascimento.twjobs.api.skills.dtos.SkillResponse;
import dev.andrenascimento.twjobs.core.models.Skill;

public interface SkillMapper {
    Skill toSkill(SkillRequest skillRequest);
    SkillResponse toSkillResponse(Skill skill);
}
