package com.em.syllabus.repository;
import com.em.syllabus.entity.SyllabusTagMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusTagMappingRepository extends JpaRepository<SyllabusTagMappingEntity, Integer> {
    SyllabusTagMappingEntity findBySyllabusTagMappingIdAndIsActive(Integer syllabusTagMappingId, Integer isActive);

}
