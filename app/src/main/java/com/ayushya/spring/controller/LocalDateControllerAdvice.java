package com.ayushya.spring.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class LocalDateControllerAdvice {
 
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
    	  DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDate.parse(text, dTF);
      }
    });
  }
}