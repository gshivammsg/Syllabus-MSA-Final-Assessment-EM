package com.em.syllabus.entity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "syllabus")
public class SyllabusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "syllabus_name")
    private String syllabusName;

    @Column(name = "description")
    private String description;

    @Column(name = "topics")
    private String topics;

    @Column(name = "duration")
    private String duration;

    @Column(name = "is_active")
    @Builder.Default
    private Integer isActive = 1;
}