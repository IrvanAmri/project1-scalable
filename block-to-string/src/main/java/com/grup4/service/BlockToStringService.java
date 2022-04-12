package com.grup4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.grup4.helper.Helper;
import com.grup4.model.repo.BlockRepo;

import org.springframework.stereotype.Service;

@Service
public class BlockToStringService {
    
    public String service(String json) throws JsonMappingException, JsonProcessingException{
        //to block repo
        BlockRepo blockRepo = Helper.jsonToBlockRepo(json);

        //invers mapping
        return Helper.inverseMapping(blockRepo);
    }
}
