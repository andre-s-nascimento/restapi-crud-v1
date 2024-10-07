package dev.andrenascimento.twjobs.config;

import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.andrenascimento.twjobs.api.jobs.dtos.JobRequest;
import dev.andrenascimento.twjobs.core.models.Job;
import dev.andrenascimento.twjobs.core.models.Skill;
import dev.andrenascimento.twjobs.core.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ModelMapperConfig {

    private final SkillRepository skillRepository;

    @Bean
    ModelMapper modelMapper() {
        var modelmapper = new ModelMapper();

        modelmapper.createTypeMap(JobRequest.class, Job.class)
                .addMappings(mapper -> mapper
                    .using(toListOfSkills())
                    .map(JobRequest::getSkills, Job::setSkills));
        return modelmapper;
    }

    private Converter<List<Long>, List<Skill>> toListOfSkills() {
        return context -> skillRepository.findAllById(context.getSource());
    }
}
