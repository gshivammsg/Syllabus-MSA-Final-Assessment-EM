package com.em.syllabus.services;

import com.em.syllabus.dto.request_dto.SyllabusRequestDTO;
import com.em.syllabus.dto.response_dto.GetAllSyllabusResponseDTO;
import com.em.syllabus.dto.response_dto.SyllabusResponseDTO;

public interface SyllabusService {
        SyllabusResponseDTO addSyllabus(SyllabusRequestDTO syllabusRequestDTO);

        GetAllSyllabusResponseDTO getAllSyllabus();

        SyllabusResponseDTO getSyllabusById(Integer id);

        SyllabusResponseDTO updateSyllabusById(SyllabusRequestDTO syllabusRequestDTO);
        SyllabusResponseDTO deleteSyllabusById(Integer id);

}
