package com.em.syllabus.dto.responseDto;

import com.em.syllabus.utils.ResponseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AllTagResponseDTO extends ResponseModel {
    @JsonProperty("tag_list")
    private List<TagResponseDTO> allTagResponseData;
}
