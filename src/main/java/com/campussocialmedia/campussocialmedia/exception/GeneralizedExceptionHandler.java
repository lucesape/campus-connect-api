package com.campussocialmedia.campussocialmedia.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;


//Used to apply the logic to all controller classes
@ControllerAdvice
@RestController
public class GeneralizedExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleAllGeneralExceptions(Exception ex, WebRequest req){
        
        //creating the exception response object
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), ex.getMessage() , req.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest req){
        //create the exception response object

        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), "User with id" + ex.getMessage() + " not found", req.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(SignatureException.class)
    public final ResponseEntity<?> handleInValidTokenForUser(SignatureException ex, WebRequest req){
        //create the exception response object

        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), "User with id" + ex.getMessage() + " not found", req.getDescription(false)
        );
        System.out.print(exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(ExpiredJwtException.class)
    public final ResponseEntity<?> handleExpiredJwtException(ExpiredJwtException ex, WebRequest req){
        //create exception response object

        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date() , "JWT token expired" , req.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
