package dev.andrenascimento.twjobs.api.jobs.dtos;


import java.math.BigDecimal;

import dev.andrenascimento.twjobs.core.enums.JobLevel;
import dev.andrenascimento.twjobs.core.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    private Long id;
    private String title;
    private String description;
    private String company;
    private String location;
    private JobType type;
    private JobLevel level;
    private BigDecimal salary;

}
