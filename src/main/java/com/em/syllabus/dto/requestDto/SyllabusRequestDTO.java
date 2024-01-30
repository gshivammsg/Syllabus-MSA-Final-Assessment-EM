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

    @NotEmpty()
    @JsonProperty("syllabus_name")
    private String syllabusName;

    @NotEmpty()
    @JsonProperty("description")
    private String description;

    @NotEmpty()
    @JsonProperty("topics")
    private String topics;

    @NotEmpty()
    @JsonProperty("duration")
    private String duration;
}