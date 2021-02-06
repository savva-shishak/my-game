package com.mygdx.game.impl.city;

import java.util.ArrayList;

public class City {
    public ArrayList<Home> homes = new ArrayList<>();

    public ArrayList<Block> getBlocks() {
        ArrayList<Block> blocks = new ArrayList<>();

        for (Home home : homes) {
            for (Block block : home.getBlocks()) {
                blocks.add(new Block(home.x + block.x, home.y + block.y));
            }
        }

        return blocks;
    }
}
