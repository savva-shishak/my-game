package com.mygdx.game.impl.city;

public class Block {
    public int x, y;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equal(int x, int y) {
        return this.x == x && this.y == y;
    }
}
