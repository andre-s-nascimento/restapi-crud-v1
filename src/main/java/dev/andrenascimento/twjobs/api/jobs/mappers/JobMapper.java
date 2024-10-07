package dev.andrenascimento.twjobs.api.jobs.mappers;

import dev.andrenascimento.twjobs.api.jobs.dtos.JobRequest;
import dev.andrenascimento.twjobs.api.jobs.dtos.JobResponse;
import dev.andrenascimento.twjobs.core.models.Job;

public interface JobMapper {
    JobResponse toJobResponse(Job job);
    Job toJob(JobRequest jobRequest);
}
