package com.flightfare.flightfare.exception;

import com.flightfare.flightfare.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //json data k liye
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("Request method not supported");
        ApiErrors apiErrors=new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrors);
    }
    //request body m aae data
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("Request Body is not Readable");
        details.add(ex.getMessage());
        ApiErrors apiErrors=new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrors);
    }
    //get ki jgah post m bgej de to
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("Media not supported");
        ApiErrors apiErrors=new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrors);
    }
    //proper path name
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("Path Variable is missing");
        ApiErrors apiErrors=new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrors);
    }
    //request param is missing
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("Request Param is missing");
        ApiErrors apiErrors=new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrors);
    }
    //int ki jgah string dedi to
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("Mismatch of type");
        ApiErrors apiErrors=new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(apiErrors);
    }
    //    @ExceptionHandler(FlightNotFoundException.class)
//    public ResponseEntity<Object> handleFlightNotFoundException(FlightNotFoundException ex){
//        String message=ex.getMessage();
//        List<String> details=new ArrayList<>();
//        details.add("flight not found");
//        ApiErrors apiErrors=new ApiErrors(message,details,HttpStatus.BAD_REQUEST, LocalDateTime.now());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);
//
//    }
//
//    @ExceptionHandler(FlightNumberNotFoundException.class)
//    public ResponseEntity<Object> handleFlightNumberNotFoundException(FlightNumberNotFoundException ex){
//        String message=ex.getMessage();
//        List<String> details=new ArrayList<>();
//        details.add("Given FlightNumber not found");
//        ApiErrors apiErrors=new ApiErrors(message,details,HttpStatus.NOT_FOUND, LocalDateTime.now());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrors);
//
//    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleexception(Exception ex){
        String message=ex.getMessage();
        List<String> details=new ArrayList<>();
        details.add("other Exception");
        ApiErrors apiErrors=new ApiErrors(message,details,HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);

    }
}
