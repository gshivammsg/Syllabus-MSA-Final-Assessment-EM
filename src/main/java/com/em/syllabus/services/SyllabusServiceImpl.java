package com.em.syllabus.services;

import com.em.syllabus.dto.queryMapper.GetSyllabusQueryMapper;
import com.em.syllabus.dto.request_dto.SyllabusRequestDTO;
import com.em.syllabus.dto.response_dto.GetAllSyllabusResponseDTO;
import com.em.syllabus.dto.response_dto.SyllabusResponseDTO;
import com.em.syllabus.entity.SyllabusEntity;
import com.em.syllabus.repository.SyllabusRepository;
import com.em.syllabus.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.em.syllabus.constants.Constants.ACTIVE;
import static com.em.syllabus.constants.Constants.IN_ACTIVE;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    @Autowired()
    private SyllabusRepository syllabusRepository;


    @Override
    public SyllabusResponseDTO addSyllabus(SyllabusRequestDTO syllabusRequestDTO) {
        SyllabusEntity syllabusEntity = SyllabusEntity.builder()
                .syllabusName(syllabusRequestDTO.getSyllabusName())
                .description(syllabusRequestDTO.getDescription())
                .topics(syllabusRequestDTO.getTopics())
                .duration(syllabusRequestDTO.getDuration())
                .isActive(ACTIVE)
                .build();
        syllabusRepository.save(syllabusEntity);
        return SyllabusResponseDTO.builder()
                .syllabusName(syllabusEntity.getSyllabusName())
                .description(syllabusEntity.getDescription())
                .topics(syllabusEntity.getTopics())
                .duration(syllabusEntity.getDuration())
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.toString())
                .currentServerTime(Utils.getCurrentServerTime())
                .build();
    }

    @Override
    public GetAllSyllabusResponseDTO getAllSyllabus() {
        List<GetSyllabusQueryMapper> getSyllabusQueryMapper =  syllabusRepository.getAllSyllabusDetails();
        List<SyllabusResponseDTO> syllabusResponseDTO = new ArrayList<>();
        for (GetSyllabusQueryMapper data:getSyllabusQueryMapper){
            syllabusResponseDTO.add(SyllabusResponseDTO.builder()
                            .id(data.getId())
                            .syllabusName(data.getSyllabusName())
                            .description(data.getDescription())
                            .topics(data.getTopics())
                            .duration(data.getDuration())
                    .build());
        }
        if(syllabusResponseDTO.isEmpty()){
            return GetAllSyllabusResponseDTO.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(HttpStatus.NOT_FOUND.toString())
                    .currentServerTime(Utils.getCurrentServerTime())
                    .build();
        }
        return GetAllSyllabusResponseDTO.builder()
                .syllabusData(syllabusResponseDTO)
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.toString())
                .currentServerTime(Utils.getCurrentServerTime())
                .build();
    }


    @Override
    public SyllabusResponseDTO getSyllabusById(Integer id) {
        GetSyllabusQueryMapper getSyllabusQueryMapper = syllabusRepository.getSyllabusById(id);
        if(getSyllabusQueryMapper == null){
            return SyllabusResponseDTO.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(HttpStatus.NOT_FOUND.toString())
                    .currentServerTime(Utils.getCurrentServerTime())
                    .build();
        }
        return SyllabusResponseDTO.builder()
                .syllabusName(getSyllabusQueryMapper.getSyllabusName())
                .id(getSyllabusQueryMapper.getId())
                .topics(getSyllabusQueryMapper.getTopics())
                .description(getSyllabusQueryMapper.getDescription())
                .duration(getSyllabusQueryMapper.getDuration())
                .currentServerTime(Utils.getCurrentServerTime())
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.toString())
                .build();
    }

    @Override
    public SyllabusResponseDTO updateSyllabusById(SyllabusRequestDTO syllabusRequestDTO) {
        SyllabusEntity getSyllabusQueryMapper = syllabusRepository.findByIdAndIsActive(syllabusRequestDTO.getId(),1);

        if(getSyllabusQueryMapper == null){
            return SyllabusResponseDTO.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(HttpStatus.NOT_FOUND.toString())
                    .currentServerTime(Utils.getCurrentServerTime())
                    .build();
        }
        getSyllabusQueryMapper.setSyllabusName(syllabusRequestDTO.getSyllabusName());
        getSyllabusQueryMapper.setDuration(syllabusRequestDTO.getDuration());
        getSyllabusQueryMapper.setTopics(syllabusRequestDTO.getTopics());
        getSyllabusQueryMapper.setDescription(syllabusRequestDTO.getDescription());
        syllabusRepository.save(getSyllabusQueryMapper);
        return SyllabusResponseDTO.builder()
                .syllabusName(getSyllabusQueryMapper.getSyllabusName())
                .id(getSyllabusQueryMapper.getId())
                .topics(getSyllabusQueryMapper.getTopics())
                .description(getSyllabusQueryMapper.getDescription())
                .duration(getSyllabusQueryMapper.getDuration())
                .currentServerTime(Utils.getCurrentServerTime())
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.toString())
                .build();
    }

    @Override
    public SyllabusResponseDTO deleteSyllabusById(Integer id) {
        SyllabusEntity getSyllabusQueryMapper = syllabusRepository.findByIdAndIsActive(id,1);

        if(getSyllabusQueryMapper == null){
            return SyllabusResponseDTO.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(HttpStatus.NOT_FOUND.toString())
                    .currentServerTime(Utils.getCurrentServerTime())
                    .build();
        }
        getSyllabusQueryMapper.setIsActive(IN_ACTIVE);
        syllabusRepository.save(getSyllabusQueryMapper);
        return SyllabusResponseDTO.builder()
                .currentServerTime(Utils.getCurrentServerTime())
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.toString())
                .build();
    }

}
