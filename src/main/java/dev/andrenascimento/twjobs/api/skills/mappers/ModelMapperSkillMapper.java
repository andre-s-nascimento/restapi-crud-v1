package dev.andrenascimento.twjobs.api.skills.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dev.andrenascimento.twjobs.api.skills.dtos.SkillRequest;
import dev.andrenascimento.twjobs.api.skills.dtos.SkillResponse;
import dev.andrenascimento.twjobs.core.models.Skill;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperSkillMapper implements SkillMapper{
    
    private final ModelMapper modelMapper;
    
    @Override
    public Skill toSkill(SkillRequest skillRequest) {
        return modelMapper.map(skillRequest, Skill.class);
    }

    @Override
    public SkillResponse toSkillResponse(Skill skill) {
        return modelMapper.map(skill, SkillResponse.class);
    }
    
}
