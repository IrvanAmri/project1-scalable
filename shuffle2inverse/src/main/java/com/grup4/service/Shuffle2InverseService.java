package com.grup4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.grup4.helper.Shuffle2InverseHelper;
import com.grup4.model.entity.Block;
import com.grup4.model.repo.BlockRepo;

import org.springframework.stereotype.Service;

@Service
public class Shuffle2InverseService {
  
  public String service(String json) throws JsonMappingException, JsonProcessingException {
    BlockRepo blockRepo = Shuffle2InverseHelper.jsonToBlockRepo(json);

    BlockRepo inverseShuffledBlockRepo = shuffleInverseBlock(blockRepo);

    return Shuffle2InverseHelper.blockRepoToJson(inverseShuffledBlockRepo);
    }

  public BlockRepo shuffleInverseBlock(BlockRepo blockRepo) {
    BlockRepo inverseShuffled = new BlockRepo();

    int n = blockRepo.size();
    for(int i = 0; i < n; i++) {
      Block inverseShuffledBlock = new Block();

      Block curBlock = blockRepo.getBlocksElement(i);
      inverseShuffledBlock = shuffle2InverseBlock(curBlock);

      inverseShuffled.addBlock(inverseShuffledBlock);
    }

    return inverseShuffled;
  } 

  //shuffle block elements
  public Block shuffle2InverseBlock(Block block) {
    Block inverseShuffledBlock = new Block();

    int n = block.size();
    int[] rules = {9,2,15,6,11,8,10,14,1,0,13,7,4,12,3,5};

    for(int i = 0; i < n; i++) {
      int rule = rules[i];
      inverseShuffledBlock.setBlockElement(rule, block.getBlockElement(i));
    }

    return inverseShuffledBlock;
  }
}
