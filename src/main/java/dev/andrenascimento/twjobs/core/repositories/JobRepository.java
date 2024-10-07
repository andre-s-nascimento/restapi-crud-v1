package dev.andrenascimento.twjobs.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.andrenascimento.twjobs.core.models.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
    
}
