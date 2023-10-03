package ro.fasttrackit.course12.employees;


import lombok.Builder;

@Builder
public record Employee(
        String firstName,
        String lastName,
        Integer age,
        String position,
        Integer salary,
        JobType jobType
) {
}
