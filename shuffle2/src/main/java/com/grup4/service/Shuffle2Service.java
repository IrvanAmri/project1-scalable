package com.grup4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.grup4.helper.Shuffle2Helper;
import com.grup4.model.entity.Block;
import com.grup4.model.repo.BlockRepo;

import org.springframework.stereotype.Service;

@Service
public class Shuffle2Service {
  
  public String service(String json) throws JsonMappingException, JsonProcessingException {
    BlockRepo blockRepo = Shuffle2Helper.jsonToBlockRepo(json);

    BlockRepo shuffledBlockRepo = shuffle(blockRepo);

    return Shuffle2Helper.blockRepoToJson(shuffledBlockRepo);
    }

  public BlockRepo shuffle(BlockRepo blockRepo) {
    BlockRepo shuffled = new BlockRepo();

    int n = blockRepo.getSize();
    for(int i = 0; i < n; i++) {
      Block shuffledBlock = new Block();

      Block curBlock = blockRepo.getBlocksElement(i);
      shuffledBlock = shuffle2Block(curBlock);

      shuffled.addBlock(shuffledBlock);
    }

    return shuffled;
  } 

  //shuffle block elements
  public Block shuffle2Block(Block block) {
    Block shuffledBlock = new Block();

    int n = block.getSize();
    int[] rules = {9,2,15,6,11,8,10,14,1,0,13,7,4,12,3,5};

    for(int i = 0; i < n; i++) {
      int rule = rules[i];
      shuffledBlock.setBlockElement(i, block.getBlockElement(rule));
    }

    return shuffledBlock;
  }
}
