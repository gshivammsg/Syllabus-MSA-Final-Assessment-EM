package com.em.syllabus.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "syllabus_tag_mapping")
public class SyllabusTagMappingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "syllabus_tag_mapping_id")
    private Integer syllabusTagMappingId;

    @Column(name = "syllabus_id")
    private Integer syllabusId;

    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "is_active")
    @Builder.Default
    private Integer isActive = 1;
}
