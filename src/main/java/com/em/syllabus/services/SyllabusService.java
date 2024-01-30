package com.em.syllabus.services;

import com.em.syllabus.dto.requestDto.AddTagToSyllabusRequestDTO;
import com.em.syllabus.dto.requestDto.SyllabusRequestDTO;
import com.em.syllabus.dto.responseDto.AllSyllabusResponseDTO;
import com.em.syllabus.dto.responseDto.AllTagResponseDTO;
import com.em.syllabus.dto.responseDto.SyllabusResponseDTO;
import com.em.syllabus.dto.responseDto.SyllabusTagMappingResponseDTO;
import com.em.syllabus.utils.ResponseModel;

public interface SyllabusService {
        SyllabusResponseDTO addSyllabus(SyllabusRequestDTO syllabusRequestDTO);

        AllSyllabusResponseDTO getAllSyllabus();

        SyllabusResponseDTO getSyllabusById(Integer id);

        SyllabusResponseDTO updateSyllabusById(SyllabusRequestDTO syllabusRequestDTO);
        ResponseModel deleteSyllabusById(Integer id);

        SyllabusTagMappingResponseDTO addTagToSyllabus(AddTagToSyllabusRequestDTO addTagToSyllabusRequestDTO);

        ResponseModel removeTagFromSyllabus(Integer syllabusTagMappingId);

        AllTagResponseDTO getTagsBySyllabusId(Integer syllabusId);

        ResponseModel deleteTagAssociatedBySyllabusId(AddTagToSyllabusRequestDTO addTagToSyllabusRequestDTO);
}
