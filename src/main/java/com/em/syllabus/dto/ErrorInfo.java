package com.em.syllabus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Error info.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
    private String field;
    private String message;
}

