package com.example.backend.recipes.controllers;

import com.example.backend.recipes.controllers.bean.ErrorBean;
import com.example.backend.recipes.exceptions.DishNotFoundException;
import com.example.backend.recipes.exceptions.RecipeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomErrorController {

    private ResponseEntity<ErrorBean> handleNotFoundException(Exception ex, WebRequest request) {

        ErrorBean exceptionResponse = new ErrorBean(
                new Date(), ex.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());

        return new ResponseEntity<ErrorBean>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(RecipeNotFoundException.class)
    public final ResponseEntity<ErrorBean> handleNotFoundException(RecipeNotFoundException ex, WebRequest request) {
        return this.handleNotFoundException(ex, request);
    }

    @ExceptionHandler(DishNotFoundException.class)
    public final ResponseEntity<ErrorBean> handleNotFoundException(DishNotFoundException ex, WebRequest request) {
        return this.handleNotFoundException(ex, request);
    }
}
