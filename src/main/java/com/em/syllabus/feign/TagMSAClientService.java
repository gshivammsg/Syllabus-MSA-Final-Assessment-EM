package com.em.syllabus.feign;

import com.em.syllabus.dto.response_dto.TagResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.em.syllabus.constants.Constants.TAG_MSA_URL;

@FeignClient(url = TAG_MSA_URL, name = "Tag-MSA")
public interface TagMSAClientService {

    @GetMapping("getTagById/{id}")
    public TagResponseDTO getTagById(@PathVariable Integer id);

}
