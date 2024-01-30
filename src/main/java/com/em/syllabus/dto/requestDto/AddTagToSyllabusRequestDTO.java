package com.em.syllabus.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddTagToSyllabusRequestDTO {

    @Min(value = 1)
    @NotNull
    @JsonProperty("syllabus_id")
    private Integer syllabusId;

    @Min(value = 1)
    @NotNull
    @JsonProperty("tag_id")
    private Integer tagId;
}
