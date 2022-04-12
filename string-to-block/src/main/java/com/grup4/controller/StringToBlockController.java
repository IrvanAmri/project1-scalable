package com.grup4.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.grup4.service.StringToBlockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blocks")
public class StringToBlockController {

    @Autowired
    private StringToBlockService service;

    @GetMapping
    public ResponseEntity<String> getBlocks(@RequestParam(name="plain") String plain) throws JsonProcessingException{
        return new ResponseEntity<String>(service.stringToBlockJson(plain), HttpStatus.OK);
    }
}
