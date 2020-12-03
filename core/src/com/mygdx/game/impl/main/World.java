package com.mygdx.game.impl.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
    public float width;
    public float height;

    public OrthographicCamera camera;

    public World(int width, int height) {
        resize(width, height);
    }

    public void resize(int width, int height) {
        this.width = 100.0f;
        this.height = this.width * height / width;

        camera = new OrthographicCamera(20, 20.0f * height/width);
    }

    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
    }
}
