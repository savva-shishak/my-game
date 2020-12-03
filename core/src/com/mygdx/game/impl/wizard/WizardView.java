package com.mygdx.game.impl.wizard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.interfaces.View;

public class WizardView implements View {
    private Texture front;
    private Texture left;
    private Texture right;
    private Texture back;

    private final Wizard wizard;

    public WizardView(Wizard wizard) {
        this.wizard = wizard;
    }

    @Override
    public void init() {
        front = new Texture("wizard/front.png");
        left = new Texture("wizard/left.png");
        right = new Texture("wizard/right.png");
        back = new Texture("wizard/back.png");
    }

    @Override
    public void render(SpriteBatch batch) {
        Texture direction = getDirection();

        float width = (float) direction.getWidth() / direction.getHeight();

        wizard.height = 1;
        wizard.width = width;

        batch.draw(direction, wizard.x, wizard.y, width, 1);
    }

    @Override
    public void dispose() {
        front.dispose();
        left.dispose();
        right.dispose();
        back.dispose();
    }

    private Texture getDirection() {
        switch (wizard.direction) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case BACK:
                return back;
            default:
                return front;
        }
    }
}
