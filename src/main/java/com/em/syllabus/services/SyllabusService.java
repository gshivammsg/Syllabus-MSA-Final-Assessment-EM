package com.em.syllabus.services;

import com.em.syllabus.dto.request_dto.AddTagToSyllabusRequestDTO;
import com.em.syllabus.dto.request_dto.SyllabusRequestDTO;
import com.em.syllabus.dto.response_dto.GetAllSyllabusResponseDTO;
import com.em.syllabus.dto.response_dto.SyllabusResponseDTO;
import com.em.syllabus.dto.response_dto.SyllabusTagMappingResponseDTO;
import com.em.syllabus.dto.response_dto.tagListBySyllabusId.TagListBySyllabusIdResponseDTO;
import com.em.syllabus.utils.ResponseModel;

public interface SyllabusService {
        SyllabusResponseDTO addSyllabus(SyllabusRequestDTO syllabusRequestDTO);

        GetAllSyllabusResponseDTO getAllSyllabus();

        SyllabusResponseDTO getSyllabusById(Integer id);

        SyllabusResponseDTO updateSyllabusById(SyllabusRequestDTO syllabusRequestDTO);
        ResponseModel deleteSyllabusById(Integer id);

        SyllabusTagMappingResponseDTO addTagToSyllabus(AddTagToSyllabusRequestDTO addTagToSyllabusRequestDTO);

        ResponseModel removeTagFromSyllabus(Integer syllabusTagMappingId);
}
