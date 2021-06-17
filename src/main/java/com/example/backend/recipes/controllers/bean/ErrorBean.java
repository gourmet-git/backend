package com.example.backend.recipes.controllers.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorBean {
    private Date timestamp;
    private String message;
    private String details;
    private String httpCodeMessage;

}
