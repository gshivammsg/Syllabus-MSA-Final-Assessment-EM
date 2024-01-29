package com.em.syllabus.repository;
import com.em.syllabus.entity.SyllabusTagMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyllabusTagMappingRepository extends JpaRepository<SyllabusTagMappingEntity, Integer> {
    SyllabusTagMappingEntity findBySyllabusTagMappingIdAndIsActive(Integer syllabusTagMappingId, Integer isActive);
    List<SyllabusTagMappingEntity> findBySyllabusIdAndTagId(Integer syllabusId, Integer tagId);
    void deleteAllBySyllabusId(Integer syllabusId);

    SyllabusTagMappingEntity findBySyllabusIdAndTagIdAndIsActive(Integer syllabusId, Integer tagId, Integer isActive);
    List<SyllabusTagMappingEntity> findAllBySyllabusIdAndIsActive(Integer syllabusId, Integer isActive);

}
