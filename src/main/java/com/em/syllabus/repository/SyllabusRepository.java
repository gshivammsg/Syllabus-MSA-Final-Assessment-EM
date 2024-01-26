package com.em.syllabus.repository;

import com.em.syllabus.dto.queryMapper.GetSyllabusQueryMapper;
import com.em.syllabus.dto.request_dto.SyllabusRequestDTO;
import com.em.syllabus.entity.SyllabusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SyllabusRepository extends JpaRepository<SyllabusEntity,Integer> {

    @Query(value = "SELECT new com.em.syllabus.dto.queryMapper.GetSyllabusQueryMapper(SM.id, SM.syllabusName, SM.description, SM.topics, SM.duration) FROM SyllabusEntity SM WHERE SM.isActive = 1")
    List<GetSyllabusQueryMapper> getAllSyllabusDetails();

    @Query(value = "SELECT new com.em.syllabus.dto.queryMapper.GetSyllabusQueryMapper(SM.id, SM.syllabusName, SM.description, SM.topics, SM.duration) FROM SyllabusEntity SM WHERE SM.id =:id AND SM.isActive = 1")
    GetSyllabusQueryMapper getSyllabusById(Integer id);

    SyllabusEntity findBySyllabusIdAndIsActive(Integer id,Integer isActive);


    @Modifying
    @Transactional
    @Query(value = "UPDATE SyllabusEntity SM SET SM.isActive = 0 WHERE SM.id =:id")
    Integer deleteSyllabusById(Integer id);
}
