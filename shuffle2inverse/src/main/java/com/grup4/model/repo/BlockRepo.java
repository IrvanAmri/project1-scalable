package com.grup4.model.repo;

import java.util.ArrayList;

import com.grup4.model.entity.Block;

public class BlockRepo {

    private ArrayList<Block> blocks;

    public BlockRepo() {
        this.blocks = new ArrayList<>();
    }

    public BlockRepo(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public Block getBlocksElement(int index) {
        return blocks.get(index);
    }

    public void setBlocksElement(int index, Block block) {
        this.blocks.set(index, block);
    }

    public void addBlock(Block block){
        this.blocks.add(block);
    }
    
    public int size() {
        return this.blocks.size();
    }
}
