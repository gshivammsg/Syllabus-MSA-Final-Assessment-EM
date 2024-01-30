package com.em.syllabus.dto.responseDto;

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
public class AllSyllabusResponseDTO extends ResponseModel{
    @JsonProperty("syllabus_data")
    private List<SyllabusResponseDTO> syllabusData;
}
