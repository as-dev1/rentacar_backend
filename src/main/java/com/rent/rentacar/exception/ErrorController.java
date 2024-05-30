package com.rent.rentacar.exception;

import com.rent.rentacar.exception.custom.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundException(NotFoundException exception, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("path", request.getServletPath());
        map.put("name", exception.getClass().getSimpleName());
        map.put("message", exception.getMessage());
        return map;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        ExceptionModel model = new ExceptionModel();
        model.setName(e.getClass().getSimpleName());
        model.setMessage("Data integrity was breached");
        model.setPath(request.getServletPath());
        return model;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleException(Exception e, HttpServletRequest request) {
        ExceptionModel model = new ExceptionModel();
        model.setMessage(e.getMessage());
        model.setName(e.getClass().getSimpleName());
        model.setPath(request.getServletPath());
        return model;
    }
}
