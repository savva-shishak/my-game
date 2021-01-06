package com.mygdx.game.impl.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.impl.DisplayImpl;
import com.mygdx.game.interfaces.Display;

public class World {
    public float width;
    public float height;
    public int kf = 100;

    private Display display;

    public OrthographicCamera camera;

    public World(int width, int height) {
        resize(width, height);
    }

    public void resize(int width, int height) {
        display = new DisplayImpl(width, height);

        this.width = kf;
        this.height = this.width * height / width;

        camera = new OrthographicCamera(20, 20.0f * height/width);
    }

    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
    }

    public Display getDisplay() {
        return display;
    }
}
