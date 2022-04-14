package com.grup4.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.grup4.models.entities.Block;
import com.grup4.models.repos.BlockRepo;

public class Helper {
    
    //Json to BlockRepo
    public static BlockRepo jsonToBlockRepo(String json) throws JsonMappingException, JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, BlockRepo.class);
    }

    //BlockRepo to Json
    public static String blockRepoToJson(BlockRepo blockRepo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        return mapper.writeValueAsString(blockRepo);
    }

    //XOR Operation
    public static Block xorOperation(Block block) {
        int[] key = {2,6,12,8,10,25,5,1,11,24,9,13,15,4,7,20};

        Block hasilBlock = new Block();

        for(int i = 0; i < 16; i++) {
            int xor = block.getBlockElement(i)^key[i];
            hasilBlock.setBlockElement(i, xor);
        }

        return hasilBlock;
    }
}
