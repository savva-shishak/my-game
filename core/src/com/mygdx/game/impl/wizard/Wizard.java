package com.mygdx.game.impl.wizard;

public class Wizard {
    public float x = 0;
    public float y = 0;

    public float width;
    public float height;

    public Direction direction = Direction.FRONT;

    public enum Direction {
        FRONT, LEFT, RIGHT, BACK
    }
}
