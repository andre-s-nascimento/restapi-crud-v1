package dev.andrenascimento.twjobs.api.skills.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.andrenascimento.twjobs.api.skills.dtos.SkillRequest;
import dev.andrenascimento.twjobs.api.skills.dtos.SkillResponse;
import dev.andrenascimento.twjobs.api.skills.mappers.SkillMapper;
import dev.andrenascimento.twjobs.core.exceptions.SkillNotFoundException;
import dev.andrenascimento.twjobs.core.repositories.SkillRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/skills")
public class SkillRestController {
    
    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;

    @GetMapping
    public List<SkillResponse> findAll(){

        return skillRepository.findAll()
            .stream()
            .map(skillMapper::toSkillResponse)
            .toList();
    }

    @GetMapping("/{id}")
    public SkillResponse findById(@PathVariable Long id) {
        return skillRepository.findById(id)
            .map(skillMapper::toSkillResponse)
            .orElseThrow(SkillNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public SkillResponse create(@Valid @RequestBody SkillRequest skillRequest) {
        var skill = skillMapper.toSkill(skillRequest);
        skill = skillRepository.save(skill);
        return skillMapper.toSkillResponse(skill);     
    }
    
    @PutMapping("/{id}")
    public SkillResponse update(
        @PathVariable Long id, 
        @Valid @RequestBody SkillRequest skillRequest) {
        var skill = skillRepository.findById(id)
            .orElseThrow(SkillNotFoundException::new);

        BeanUtils.copyProperties(skillRequest, skill, "id");

        skill = skillRepository.save(skill);  
            return skillMapper.toSkillResponse(skill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
        @PathVariable Long id){
            var skill = skillRepository.findById(id)
            .orElseThrow(SkillNotFoundException::new);

            skillRepository.delete(skill);    
        
        }
}
