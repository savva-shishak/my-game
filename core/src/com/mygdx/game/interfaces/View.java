package com.mygdx.game.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface View {
    void init();
    void render(SpriteBatch batch);
    void dispose();
}
