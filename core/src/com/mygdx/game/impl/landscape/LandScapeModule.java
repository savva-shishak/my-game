package com.mygdx.game.impl.landscape;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.interfaces.Module;

import java.util.Random;

public class LandScapeModule implements Module {
    private final World world;
    private Texture justPlace;
    private Texture grass;
    private boolean[][] place;

    public LandScapeModule(World world) {
        this.world = world;
    }

    @Override
    public void init() {
        justPlace = new Texture("landscape/just-place.png");
        grass = new Texture("landscape/grass.png");
        fillPlace();
    }

    @Override
    public void render(SpriteBatch batch) {
        for (int i = 0; i < world.height + 1; i++) {
            for (int j = 0; j < world.width + 1; j++) {
                batch.draw(place[i][j]? grass : justPlace, j, i, 1, 1);
            }
        }
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void dispose() {
        justPlace.dispose();
    }

    private void fillPlace() {
        Random random = new Random();
        place = new boolean[(int) world.height + 1][(int) world.width + 1];
        for (int i = 0; i < world.height + 1; i++) {
            for (int j = 0; j < world.width + 1; j++) {
                place[i][j] = random.nextBoolean();
            }
        }
    }
}
