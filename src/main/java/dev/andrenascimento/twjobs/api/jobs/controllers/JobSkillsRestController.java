package dev.andrenascimento.twjobs.api.jobs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.andrenascimento.twjobs.api.skills.dtos.SkillResponse;
import dev.andrenascimento.twjobs.api.skills.mappers.SkillMapper;
import dev.andrenascimento.twjobs.core.exceptions.JobNotFoundException;
import dev.andrenascimento.twjobs.core.repositories.JobRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs/{id}/skills")
public class JobSkillsRestController {
    
    private final SkillMapper skillMapper;
    private final JobRepository jobRepository;

        @GetMapping
    public List<SkillResponse> findSkillsByJobId(@PathVariable Long id) {
        
        var job = jobRepository.findById(id)
        .orElseThrow(JobNotFoundException::new);

        return job.getSkills()
            .stream()
            .map(skillMapper::toSkillResponse)
            .toList();
    }
}
