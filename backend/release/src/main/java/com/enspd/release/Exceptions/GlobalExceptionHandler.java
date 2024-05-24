package com.enspd.release.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    /*
     * handling RessourceNot found Exception
     */
    @ExceptionHandler(value= RessourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse HandleRessourceNotFoundException(RessourceNotFoundException r){
        ErrorResponse errorResponse= new ErrorResponse();

        errorResponse.setDate(new Date(System.currentTimeMillis()));
        errorResponse.setError(r.getMessage());
        errorResponse.setStatus_Code(HttpStatus.NOT_FOUND.value());

        return errorResponse;
    }


    @ExceptionHandler(value = PathUsedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse HandlePathUsedException(PathUsedException p){

        ErrorResponse errorResponse= new ErrorResponse();

        errorResponse.setDate(new Date(System.currentTimeMillis()));
        errorResponse.setError(p.getMessage());
        errorResponse.setStatus_Code(HttpStatus.NOT_FOUND.value());

        return errorResponse;
    }

    @ExceptionHandler(value=NullArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse HandleBadRequest(NullArgumentException n){
        ErrorResponse errorResponse= new ErrorResponse();

        errorResponse.setDate(new Date(System.currentTimeMillis()));
        errorResponse.setError(n.getMessage());
        errorResponse.setStatus_Code(HttpStatus.BAD_REQUEST.value());

        return errorResponse;
    }

    
    
}
