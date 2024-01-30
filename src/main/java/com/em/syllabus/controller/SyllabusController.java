package com.em.syllabus.controller;

import com.em.syllabus.dto.requestDto.AddTagToSyllabusRequestDTO;
import com.em.syllabus.dto.requestDto.SyllabusRequestDTO;
import com.em.syllabus.dto.responseDto.AllSyllabusResponseDTO;
import com.em.syllabus.dto.responseDto.AllTagResponseDTO;
import com.em.syllabus.dto.responseDto.SyllabusResponseDTO;
import com.em.syllabus.dto.responseDto.SyllabusTagMappingResponseDTO;
import com.em.syllabus.services.SyllabusService;
import com.em.syllabus.utils.ResponseModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import static com.em.syllabus.constants.EndPointsConstants.*;


@RestController
@RequestMapping(SYLLABUS_API)
@CrossOrigin(origins = "*")
public class SyllabusController {
    @Autowired
    private SyllabusService syllabusService;
    @PostMapping(ADD_SYLLABUS)
    public SyllabusResponseDTO addSyllabus( @RequestBody @Valid SyllabusRequestDTO syllabusRequestDTO){
        return syllabusService.addSyllabus(syllabusRequestDTO);
    }

    @GetMapping(GET_ALL_SYLLABUS)
    public AllSyllabusResponseDTO allSyllabus(){
        return syllabusService.getAllSyllabus();
    }

    @Cacheable(key = "#id", value = "getSyllabusById")
    @GetMapping(GET_SYLLABUS_BY_ID+"/{id}")
    public SyllabusResponseDTO syllabusById(@PathVariable Integer id){
        System.out.println("get syllabus by id ki caching -----> ");
        return syllabusService.getSyllabusById(id);
    }


    @CacheEvict(key = "#syllabusRequestDTO.getId", value = "getSyllabusById")
    @PostMapping(UPDATE_SYLLABUS_BY_ID)
    public SyllabusResponseDTO updateSyllabusById(@Valid @RequestBody SyllabusRequestDTO syllabusRequestDTO){
        return syllabusService.updateSyllabusById(syllabusRequestDTO);
    }

    @CacheEvict(key = "#id", value = "getSyllabusById")
    @DeleteMapping(DELETE_SYLLABUS_BY_ID+"/{id}")
    public ResponseModel deleteSyllabusById(@PathVariable Integer id){
        return syllabusService.deleteSyllabusById(id);
    }

    @PostMapping(ADD_TAG_TO_SYLLABUS)
    public SyllabusTagMappingResponseDTO addTagToSyllabus(@Valid @RequestBody AddTagToSyllabusRequestDTO addTagToSyllabusRequestDTO){
        return syllabusService.addTagToSyllabus(addTagToSyllabusRequestDTO);
    }

    @PutMapping(REMOVE_TAG_FROM_SYLLABUS+"/{id}")
    public ResponseModel removeTagFromSyllabus(@PathVariable Integer id){
        return syllabusService.removeTagFromSyllabus(id);
    }

    @GetMapping(TAGS_FROM_SYLLABUS_ID+"/{id}")
    public AllTagResponseDTO tagsBySyllabusId(@PathVariable Integer id){
        return syllabusService.getTagsBySyllabusId(id);
    }

    @PostMapping(DELETE_TAG_ASSOCIATE_BY_SYLLABUS_ID)
    public ResponseModel deleteTagAssociatedBySyllabusId(@Valid @RequestBody AddTagToSyllabusRequestDTO addTagToSyllabusRequestDTO){
        return syllabusService.deleteTagAssociatedBySyllabusId(addTagToSyllabusRequestDTO);
    }

    @CacheEvict(value = "getSyllabusById", allEntries = true)
    @GetMapping(REMOVE_CACHE)
    public String removeCache(){
        return "Cache Removed From Syllabus MSA";
    }

}
