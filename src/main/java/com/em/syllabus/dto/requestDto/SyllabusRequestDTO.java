package com.em.syllabus.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @NotEmpty(message = "syllabus_name should not be empty")
    @JsonProperty("syllabus_name")
    private String syllabusName;

    @NotEmpty(message = "syllabus_name should not be empty")
    @JsonProperty("description")
    private String description;

    @NotEmpty(message = "syllabus_name should not be empty")
    @JsonProperty("topics")
    private String topics;

    @NotEmpty(message = "syllabus_name should not be empty")
    @JsonProperty("duration")
    private String duration;
}