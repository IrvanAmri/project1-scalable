package com.grup4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.grup4.helper.Helper1;
import com.grup4.model.repo.BlockRepo;

import org.springframework.stereotype.Service;

@Service
public class StringToBlockService {
    
    public String stringToBlockJson(String plain) throws JsonProcessingException{
        BlockRepo blockRepo = Helper1.processing(plain);
        return Helper1.blockRepoToJson(blockRepo);
    }
}
