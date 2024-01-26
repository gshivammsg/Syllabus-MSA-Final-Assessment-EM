package com.em.syllabus.dto.response_dto;


import com.em.syllabus.utils.ResponseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SyllabusTagMappingResponseDTO extends ResponseModel {

    @JsonProperty("syllabus_tag_mapping_id")
    private Integer syllabusTagMappingId;

}
