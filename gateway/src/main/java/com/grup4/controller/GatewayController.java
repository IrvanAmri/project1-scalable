package com.grup4.controller;

import com.grup4.service.GatewayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GatewayController {
    

    @Autowired
    private GatewayService service;

    @GetMapping("/cipher")
    public ResponseEntity<String> enkripsi(@RequestParam(name="plain") String plaintext){
        GatewayService.setKontrolEnkripsi(false);
        service.enkripsiService(plaintext);
        while(!GatewayService.isKontrolEnkripsi()){
            System.out.println("");
        }
        return new ResponseEntity<String>(service.blocksToString(GatewayService.getCipherSaver()), HttpStatus.OK);
    }
}
