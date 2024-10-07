package dev.andrenascimento.twjobs.api.jobs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.andrenascimento.twjobs.api.jobs.dtos.JobRequest;
import dev.andrenascimento.twjobs.api.jobs.dtos.JobResponse;
import dev.andrenascimento.twjobs.api.jobs.mappers.JobMapper;
import dev.andrenascimento.twjobs.core.exceptions.JobNotFoundException;
import dev.andrenascimento.twjobs.core.repositories.JobRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobRestController {

    private final JobMapper jobMapper;
    private final JobRepository jobRepository;

    @GetMapping
    public List<JobResponse> findAll() {
        return jobRepository.findAll()
                .stream()
                .map(jobMapper::toJobResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public JobResponse findById(@PathVariable Long id) {
        var job = jobRepository.findById(id)
                .orElseThrow(JobNotFoundException::new);

        return jobMapper.toJobResponse(job);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public JobResponse create(@RequestBody @Valid JobRequest jobRequest) {
        var job = jobMapper.toJob(jobRequest);

        job = jobRepository.save(job);

        return jobMapper.toJobResponse(job);

    }

    @PutMapping("/{id}")
    public JobResponse update(@PathVariable Long id, @RequestBody @Valid JobRequest jobRequest) {
        var job = jobRepository.findById(id)
                .orElseThrow(JobNotFoundException::new);
        var jobData = jobMapper.toJob(jobRequest);
        BeanUtils.copyProperties(jobData, job, "id");
        job = jobRepository.save(job);
        return jobMapper.toJobResponse(job);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        var job = jobRepository.findById(id)
        .orElseThrow(JobNotFoundException::new);

        jobRepository.delete(job);
    }

}
