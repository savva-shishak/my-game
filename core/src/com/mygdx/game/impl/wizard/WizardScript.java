package com.mygdx.game.impl.wizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.interfaces.Script;

public class WizardScript implements Script {

    private final Wizard wizard;
    private final World world;

    public WizardScript(Wizard wizard, World world) {
        this.wizard = wizard;
        this.world = world;
    }

    @Override
    public void init() {

        OrthographicCamera camera = world.camera;

//        camera.zoom /= 4;
//
//        camera.update();
    }

    @Override
    public void update(float deltaTime) {
        float distance = 5.0f * deltaTime;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            wizard.direction = Wizard.Direction.LEFT;
            wizard.x -= distance;

        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            wizard.direction = Wizard.Direction.RIGHT;
            wizard.x += distance;

        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            wizard.direction = Wizard.Direction.BACK;
            wizard.y += distance;

        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            wizard.direction = Wizard.Direction.FRONT;
            wizard.y -= distance;

        } else {
            wizard.direction = Wizard.Direction.FRONT;
        }

        OrthographicCamera camera = world.camera;

        camera.position.x = wizard.x + wizard.width/2;
        camera.position.y = wizard.y + wizard.height/2;

        alignWizard();
        alignCamera();
    }

    private void alignWizard() {
        if (wizard.x < 0) {
            wizard.x = 0;
        }

        if (wizard.y < 0) {
            wizard.y = 0;
        }

        if (wizard.x + wizard.width >= world.width) {
            wizard.x = world.width - wizard.width;
        }

        if (wizard.y + wizard.height >= world.height) {
            wizard.y = world.height - wizard.height;
        }
    }

    private void alignCamera() {
        Vector3 position = world.camera.position;

        float rWidth = world.camera.viewportWidth / 2;
        float rHeight = world.camera.viewportHeight / 2;

        if (position.x < rWidth) {
            position.x = rWidth;
        }

        if (position.y < rHeight) {
            position.y = rHeight;
        }

        if (position.x + rWidth > world.width) {
            position.x = world.width - rWidth;
        }

        if (position.y + rHeight > world.height) {
            position.y = world.height - rHeight;
        }

        world.camera.update();
    }
}
