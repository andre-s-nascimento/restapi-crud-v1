package dev.andrenascimento.twjobs.api.jobs.dtos;

import java.util.List;
import java.math.BigDecimal;

import dev.andrenascimento.twjobs.core.enums.JobLevel;
import dev.andrenascimento.twjobs.core.enums.JobType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {

    @NotEmpty
    @Size(min = 5, max = 100)
    private String title;

    @NotEmpty
    @Size(min = 10, max = 255)
    private String description;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String company;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String location;
    
    @NotNull
    private JobType type;

    @NotNull
    private JobLevel level;

    @NotNull
    @PositiveOrZero
    private BigDecimal salary;

    @NotEmpty
    private List<Long> skills;
}
