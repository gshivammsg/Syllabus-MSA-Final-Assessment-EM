package com.em.syllabus.dto.response_dto;

import com.em.syllabus.utils.ResponseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SyllabusResponseDTO extends ResponseModel{
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
