package com.grup4.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.grup4.helpers.Helper;
import com.grup4.models.entities.Block;
import com.grup4.models.repos.BlockRepo;

import org.springframework.stereotype.Service;

@Service
public class Shuffle1InverseService {

    public String service(String json)  throws JsonProcessingException{
        BlockRepo blockRepo = Helper.jsonToBlockRepo(json);

        BlockRepo inverseShuffledBlockRepo = shuffleInverse(blockRepo);

        return Helper.blockRepoToJson(inverseShuffledBlockRepo);

    }
    
    public BlockRepo shuffleInverse(BlockRepo blockRepo) {

        BlockRepo inverseShuffled = new BlockRepo();

        int n = blockRepo.size();
        for (int i = 0; i < n; i++) {
            Block inverseShuffledBlock = new Block();
            
            Block curBlock = blockRepo.getBlocksElement(i);
            inverseShuffledBlock = shuffleInverseBlock(curBlock);
            
            inverseShuffled.addBlock(inverseShuffledBlock);

        }

        return inverseShuffled;
    }

    //shuffle block elements
    public Block shuffleInverseBlock(Block block) {

        Block inverseShuffledBlock = new Block();

        int n = block.size();
        int[] rules = {3,6,11,0,5,4,1,15,14,13,12,2,10,9,8,7};
        
        for (int i = 0; i < n; i++) {
            int rule = rules[i];
            inverseShuffledBlock.setBlockElement(rule, block.getBlockElement(i));
        }

        return inverseShuffledBlock;
    }

}
