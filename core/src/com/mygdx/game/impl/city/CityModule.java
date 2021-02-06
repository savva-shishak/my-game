package com.mygdx.game.impl.city;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.interfaces.View;

public class CityModule extends ModuleAdapter {

    public CityModule(City city) {
        this.city = city;
    }

    private final City city;

    @Override
    protected void beforeInit() {

        views.add(new View() {
            Texture textureBlock;

            @Override
            public void init() {
                textureBlock = new Texture("city/block.png");
            }

            @Override
            public void render(SpriteBatch batch) {
                for (Block block : city.getBlocks()) {
                    batch.draw(textureBlock, block.x, block.y, 1, 1);
                }
            }

            @Override
            public void dispose() {
                textureBlock.dispose();
            }
        });
    }
}
