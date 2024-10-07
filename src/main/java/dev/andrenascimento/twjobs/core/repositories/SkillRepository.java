package dev.andrenascimento.twjobs.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.andrenascimento.twjobs.core.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long>{

    boolean existsByName(String value);

    boolean existsByNameAndIdNot(String name, Long id);
    
}
