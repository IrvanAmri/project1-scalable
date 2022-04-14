package com.grup4.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.grup4.model.repo.BlockRepo;

public class Shuffle2Helper {

  // Json to BlockRepo
  public static BlockRepo jsonToBlockRepo(String json) throws JsonMappingException, JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();

    return mapper.readValue(json, BlockRepo.class);
  }

  //Block to Json
  public static String blockRepoToJson(BlockRepo blockRepo) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    return mapper.writeValueAsString(blockRepo);
  }
}
