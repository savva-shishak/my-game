package com.mygdx.game.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Module {
    void init();

    void render(SpriteBatch batch);
    void update(float deltaTime);

    void dispose();
}
