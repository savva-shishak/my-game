package com.mygdx.game.impl.city;

import com.badlogic.gdx.utils.Array;

public class Home {
    public int x, y;
    private Array<Room> rooms = new Array<>();

    public Home(int x, int y) {
        this.x = x;
        this.y = y;

        rooms.add(new Room(0, 0, true, true, true, false));
        rooms.add(new Room(0, -1, true, false, false, false));
        rooms.add(new Room(0, 1, false, false, true, false));
    }

    public Array<Block> getBlocks() {
        Array<Block> blocks = new Array<>();

        for (Room room : rooms) {
            for (Block block : room.getBlocks()) {
                blocks.add(new Block(block.x, block.y));
            }
        }

        return blocks;
    }
}
