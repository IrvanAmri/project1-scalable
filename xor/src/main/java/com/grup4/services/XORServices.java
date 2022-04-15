package com.grup4.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.grup4.helpers.Helper;
import com.grup4.models.entities.Block;
import com.grup4.models.repos.BlockRepo;

public class XORServices {
  
  public String service(String json) throws JsonMappingException, JsonProcessingException {
    BlockRepo blockRepo = Helper.jsonToBlockRepo(json);

    BlockRepo xorBlockRepo = xorServices(blockRepo);

    return Helper.blockRepoToJson(xorBlockRepo);
  }

  public BlockRepo xorServices(BlockRepo blockRepo) {

    BlockRepo xor = new BlockRepo();

    int n = blockRepo.size();
    for(int i = 0; i < n; i++) {
      Block xorBlock = new Block();

      Block curBlock = blockRepo.getBlocksElement(i);
      xorBlock = Helper.xorOperation(curBlock);

      xor.addBlock(xorBlock);
    }

    return xor;
  }
}
