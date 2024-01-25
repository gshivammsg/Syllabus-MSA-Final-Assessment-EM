package com.em.syllabus.dto.request_dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SyllabusRequestDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("syllabus_name")
    private String syllabusName;


    @JsonProperty("description")
    private String description;

    @JsonProperty("topics")
    private String topics;

    @JsonProperty("duration")
    private String duration;
}
//subject, description, topics, and duration