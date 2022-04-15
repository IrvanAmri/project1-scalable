package com.grup4.model.entity;

public class Block {
    
    private int block[];

    public Block() {
        block = new int[16];
    }

    public Block(int[] block) {
        this.block = block;
    }

    public int[] getBlock() {
        return block;
    }

    public void setBlock(int[] block) {
        this.block = block;
    }

    public int getBlockElement(int index) {
        return block[index];
    }

    public void setBlockElement(int index, int value) {
        this.block[index] = value;
    }

    public int size() {
        return this.block.length;
    }
}
