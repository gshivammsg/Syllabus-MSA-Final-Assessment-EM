package com.em.syllabus.dto.request_dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SyllabusRequestDTO {

    @JsonProperty("id")
    private Integer id;

    @NotEmpty(message = "syllabus_name cannot be empty")
    @JsonProperty("syllabus_name")
    private String syllabusName;

    @NotEmpty(message = "description cannot be empty")
    @JsonProperty("description")
    private String description;

    @NotEmpty(message = "topics cannot be empty")
    @JsonProperty("topics")
    private String topics;

    @NotEmpty(message = "duration cannot be empty")
    @JsonProperty("duration")
    private String duration;
}