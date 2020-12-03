package com.mygdx.game.impl;

import com.mygdx.game.interfaces.Display;

public class DisplayImpl implements Display {
    private int width;
    private int height;

    public DisplayImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
