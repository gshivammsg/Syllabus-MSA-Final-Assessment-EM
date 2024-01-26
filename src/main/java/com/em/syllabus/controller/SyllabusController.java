package com.em.syllabus.controller;

import com.em.syllabus.dto.request_dto.AddTagToSyllabusRequestDTO;
import com.em.syllabus.dto.request_dto.SyllabusRequestDTO;
import com.em.syllabus.dto.response_dto.GetAllSyllabusResponseDTO;
import com.em.syllabus.dto.response_dto.SyllabusResponseDTO;
import com.em.syllabus.dto.response_dto.SyllabusTagMappingResponseDTO;
import com.em.syllabus.dto.response_dto.tagListBySyllabusId.TagListBySyllabusIdResponseDTO;
import com.em.syllabus.services.SyllabusService;
import com.em.syllabus.utils.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.em.syllabus.constants.EndPointsConstants.*;

@RestController
@RequestMapping(SYLLABUS_API)
public class SyllabusController {
    @Autowired
    private SyllabusService syllabusService;
    @PostMapping(ADD_SYLLABUS)
    public SyllabusResponseDTO addSyllabus(@RequestBody SyllabusRequestDTO syllabusRequestDTO){
        return syllabusService.addSyllabus(syllabusRequestDTO);
    }

    @GetMapping(GET_ALL_SYLLABUS)
    public GetAllSyllabusResponseDTO getAllSyllabus(){
        return syllabusService.getAllSyllabus();
    }

    @GetMapping(GET_SYLLABUS_BY_ID+"/{id}")
    public SyllabusResponseDTO getSyllabusById(@PathVariable Integer id){
        return syllabusService.getSyllabusById(id);
    }

    @PostMapping(UPDATE_SYLLABUS_BY_ID)
    public SyllabusResponseDTO updateSyllabusById(SyllabusRequestDTO syllabusRequestDTO){
        return syllabusService.updateSyllabusById(syllabusRequestDTO);
    }

    @DeleteMapping(DELETE_SYLLABUS_BY_ID+"/{id}")
    public ResponseModel deleteSyllabusById(@PathVariable Integer id){
        return syllabusService.deleteSyllabusById(id);
    }

    @PostMapping(ADD_TAG_TO_SYLLABUS)
    public SyllabusTagMappingResponseDTO addTagToSyllabus(@RequestBody AddTagToSyllabusRequestDTO addTagToSyllabusRequestDTO){
        return syllabusService.addTagToSyllabus(addTagToSyllabusRequestDTO);
    }

    @PutMapping(REMOVE_TAG_FROM_SYLLABUS+"/{id}")
    public ResponseModel removeTagFromSyllabus(@PathVariable Integer id){
        return syllabusService.removeTagFromSyllabus(id);
    }

}
