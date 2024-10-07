package dev.andrenascimento.twjobs.api.jobs.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dev.andrenascimento.twjobs.api.jobs.dtos.JobRequest;
import dev.andrenascimento.twjobs.api.jobs.dtos.JobResponse;
import dev.andrenascimento.twjobs.core.models.Job;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModelMapperJobMapper implements JobMapper{
    

    private final ModelMapper modelMapper;

    @Override
    public JobResponse toJobResponse(Job job) {
        return modelMapper.map(job, JobResponse.class);
    }

    @Override
    public Job toJob(JobRequest jobRequest) {
        return modelMapper.map(jobRequest, Job.class);
    }
}
