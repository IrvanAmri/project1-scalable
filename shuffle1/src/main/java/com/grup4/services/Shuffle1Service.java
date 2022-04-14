package com.grup4.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.grup4.helpers.Helper;
import com.grup4.models.entities.Block;
import com.grup4.models.repos.BlockRepo;

import org.springframework.stereotype.Service;

@Service
public class Shuffle1Service {

    public String service(String json)  throws JsonProcessingException{
        BlockRepo blockRepo = Helper.jsonToBlockRepo(json);

        BlockRepo shuffledBlockRepo = shuffle(blockRepo);

        return Helper.blockRepoToJson(shuffledBlockRepo);

    }

    
    public BlockRepo shuffle(BlockRepo blockRepo) {

        BlockRepo shuffled = new BlockRepo();

        int n = blockRepo.getSize();
        for (int i = 0; i < n; i++) {
            Block shuffledBlock = new Block();
            
            Block curBlock = blockRepo.getBlocksElement(i);
            shuffledBlock = shuffleBlock(curBlock);
            
            shuffled.addBlock(shuffledBlock);

        }

        return shuffled;
    }

    //shuffle block elements
    public Block shuffleBlock(Block block) {

        Block shuffledBlock = new Block();

        int n = block.getSize();
        int[] rules = {3,6,11,0,5,4,1,15,14,13,12,2,10,9,8,7};
        
        for (int i = 0; i < n; i++) {
            int rule = rules[i];
            shuffledBlock.setBlockElement(i, block.getBlockElement(rule));
        }

        return shuffledBlock;
    }

}