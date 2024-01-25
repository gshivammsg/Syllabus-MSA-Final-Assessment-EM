package com.em.syllabus.dto.queryMapper;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetSyllabusQueryMapper {
    private Integer id;
    private String syllabusName;
    private String description;
    private String topics;
    private String duration;
}
