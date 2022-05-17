package com.raif.testtaskf.exception_handling;

import com.raif.testtaskf.projectresources.Messanger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Messanger> unknownColorExceptionHandler(UnknownColor data){
        return new ResponseEntity<>(new Messanger(data.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Messanger> noSuchSocksExceptionHandler(NoSuchSocks data){
        return new ResponseEntity<>(new Messanger(data.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Messanger> unrecognizedOperationExceptionHandler(UnrecognizedOperation data){
        return new ResponseEntity<>(new Messanger(data.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Messanger> validExceptionHandler(MethodArgumentNotValidException data){
        return new ResponseEntity<>(new Messanger("Your cotton part must be between 0 and 100. Also, quantity must be greater than 0."),HttpStatus.BAD_REQUEST);
    }
}
