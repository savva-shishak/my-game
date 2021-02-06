package com.mygdx.game.impl.city;

import com.badlogic.gdx.utils.Array;

public class Room {
    private final int x, y;
    public Array<Block> blocks = new Array<>();

    public Room(int x, int y, boolean top, boolean right, boolean bottom, boolean left) {
        this.x = x * 6;
        this.y = y * 6;

        buildXWell(-3, 3, 3);
        buildXWell(-3, 3, -3);

        buildYWell(-3, 3, 3);
        buildYWell(-3, 3, -3);

        for (int i = 0; i < blocks.size; i++) {
            Block block = blocks.get(i);
            if (
                    (left && block.equal(-3, 0)) ||
                    (right && block.equal(3, 0)) ||
                    (top && block.equal(0, 3)) ||
                    (bottom && block.equal(0, -3))
            ) {
                blocks.removeIndex(i);
            }
        }
    }

    public void buildXWell(int from, int to, int y) {
        for (int x = from; x <= to; x++) {
            blocks.add(new Block(x, y));
        }
    }

    public void buildYWell(int from, int to, int x) {
        for (int y = from; y <= to; y++) {
            blocks.add(new Block(x, y));
        }
    }

    public Array<Block> getBlocks() {
        Array<Block> mappedBlocks = new Array<>();

        for (Block block : blocks) {
            mappedBlocks.add(new Block(x + block.x, y + block.y));
        }

        return mappedBlocks;
    }
}
