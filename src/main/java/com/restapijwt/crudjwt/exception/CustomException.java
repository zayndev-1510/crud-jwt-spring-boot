package com.restapijwt.crudjwt.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class CustomException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleInvalidrequest(MethodArgumentNotValidException ex){
        Map<String,Object> errormap=new HashMap<>();
        Map<String,Object> validation=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            validation.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        errormap.put("message",validation);
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageConversionException.class)
    public Map<String, Object> handleInvalidMessageConversion(HttpMessageConversionException ex){
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        errormap.put("message",ex.getMessage());

        return errormap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, Object> handleInvalidRequestMethod(HttpRequestMethodNotSupportedException ex){
        Map<String,Object> errormap=new HashMap<>();

        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        errormap.put("message",ex.getMessage());
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String, Object> handleValueNull(SQLIntegrityConstraintViolationException ex){
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        String errorMessage = ex.getMessage();
        if(errorMessage.contains("Duplicate entry")) {
            errormap.put("message", "Data yang Anda masukkan sudah ada.");
        } else if(errorMessage.contains("cannot be null")) {
            errormap.put("message", ex.getMessage());
        } else {
            errormap.put("message", "Terjadi kesalahan validasi data. Silakan periksa kembali.");
        }
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("status",HttpStatus.BAD_REQUEST);
        errormap.put("error","Request Body Is Missing");
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Map<String,Object> handleHttpMediaTypeNotSupport(HttpMediaTypeNotSupportedException ex) {
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("status",HttpStatus.BAD_REQUEST);
        errormap.put("error",ex.getMessage());
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException.class)
    public Map<String,Object> handleMissingServletRequestPart(MissingServletRequestPartException ex) {
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("status",HttpStatus.BAD_REQUEST);
        errormap.put("error",ex.getMessage());
        return errormap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoResourceFoundException.class)
    public Map<String,Object> handleNoResourceFoundException(NoResourceFoundException ex) {
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("status",HttpStatus.NOT_FOUND);
        errormap.put("error",ex.getMessage());
        return errormap;
    }
}
