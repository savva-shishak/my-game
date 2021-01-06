package com.mygdx.game.impl.targetcell;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.interfaces.Display;
import com.mygdx.game.interfaces.Script;

public class TargetCellScript implements Script {
    private final TargetCell targetCell;
    private final World world;

    public TargetCellScript(TargetCell targetCell, World world) {
        this.targetCell = targetCell;
        this.world = world;
    }

    @Override
    public void init() {
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
            Display display = world.getDisplay();

            int xInput = Gdx.input.getX();
            int yInput = display.getHeight() - Gdx.input.getY();

            OrthographicCamera camera = world.camera;
            targetCell.isView = true;
            targetCell.x = (int) ((xInput * camera.viewportWidth / display.getWidth()) + (camera.position.x - camera.viewportWidth / 2));
            targetCell.y = (int) ((yInput * camera.viewportHeight / display.getHeight()) + (camera.position.y - camera.viewportHeight / 2));
        }
    }
}
