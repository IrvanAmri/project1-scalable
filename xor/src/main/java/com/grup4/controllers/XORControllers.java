package com.grup4.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.grup4.services.XORServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/XOR")
public class XORControllers {
    
    @Autowired
    private XORServices service;

    @GetMapping
    public ResponseEntity<String> getString(@RequestParam(name="json") String json) throws JsonMappingException, JsonProcessingException{
        return new ResponseEntity<String>(service.service(json), HttpStatus.OK);
    }
}
