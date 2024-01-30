package com.em.syllabus.exception;
import com.em.syllabus.dto.ErrorInfo;
import com.em.syllabus.utils.ResponseModel;
import com.em.syllabus.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        List<ErrorInfo> errors = new ArrayList<>();

        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
            methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.add(new ErrorInfo(fieldName, errorMessage));
            });
        }
        ResponseModel responseModel = ResponseModel.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(errors.isEmpty() ? "request is invalid":errors.get(0).getField() + " is invalid")
                .currentServerTime(Utils.getCurrentServerTime()).build();

        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

}

