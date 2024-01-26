package com.em.syllabus.dto.request_dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddTagToSyllabusRequestDTO {
    @JsonProperty("syllabus_id")
    private Integer syllabusId;
    @JsonProperty("tag_id")
    private Integer tagId;
}
