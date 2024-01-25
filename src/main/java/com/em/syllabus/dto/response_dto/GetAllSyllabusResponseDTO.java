package com.em.syllabus.dto.response_dto;

import com.em.syllabus.utils.ResponseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class GetAllSyllabusResponseDTO extends ResponseModel{
    @JsonProperty("syllabus_data")
    private List<SyllabusResponseDTO> syllabusData;
}
