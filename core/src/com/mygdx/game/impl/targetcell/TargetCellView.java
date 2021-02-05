package com.mygdx.game.impl.targetcell;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.interfaces.View;
import volnovoialgoritm.Point;

public class TargetCellView implements View {
    private Texture image;
    private Texture pathImage;
    private final TargetCell cell;

    private final Route route;

    public TargetCellView(TargetCell cell, Route route) {
        this.cell = cell;
        this.route = route;
    }

    @Override
    public void init() {
        image = new Texture("targetcell/red-cell.png");
        pathImage = new Texture("targetcell/yellow-cell.png");
    }

    @Override
    public void render(SpriteBatch batch) {
        if (cell.isView) {
            // batch.draw(image, cell.x, cell.y, 1, 1);

            for (Point point : route.path) {
                batch.draw(pathImage, point.x, point.y, 1, 1);
            }
        }
    }

    @Override
    public void dispose() {
        image.dispose();
    }
}
