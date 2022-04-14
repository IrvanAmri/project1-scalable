package com.grup4.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.grup4.service.Shuffle2Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enkriptor/shuffle-2")
public class Shuffle2Controller {
  
  @Autowired
  private Shuffle2Service service;

  @GetMapping
  public  ResponseEntity<String> getString(@RequestParam(name="json") String json) throws JsonMappingException , JsonProcessingException {
    return new ResponseEntity<String>(service.service(json), HttpStatus.OK);
  }
}
