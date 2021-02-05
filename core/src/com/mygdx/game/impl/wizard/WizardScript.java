package com.mygdx.game.impl.wizard;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.impl.targetcell.Route;
import com.mygdx.game.interfaces.Script;
import volnovoialgoritm.Point;

public class WizardScript implements Script {

    private final Wizard wizard;
    private final World world;
    private final Route route;

    public WizardScript(Wizard wizard, World world, Route route) {
        this.wizard = wizard;
        this.world = world;
        this.route = route;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float deltaTime) {
        moveByRoute(deltaTime);

        OrthographicCamera camera = world.camera;

        camera.position.x = wizard.x + wizard.width/2;
        camera.position.y = wizard.y + wizard.height/2;

        alignWizard();
        alignCamera();
    }

    private void moveByRoute(float deltaTime) {
        wizard.direction = Wizard.Direction.FRONT;

        if (route.path.size() != 0) {
            Point last = route.path.get(route.path.size() - 1);

            float distance = 5.0f * deltaTime;

            if (last.x - distance > wizard.x) {
                wizard.x += distance;
                wizard.direction = Wizard.Direction.RIGHT;

            } else if (last.x + distance < wizard.x) {
                wizard.x -= distance;
                wizard.direction = Wizard.Direction.LEFT;


            }  else if (last.y - distance > wizard.y) {
                wizard.y += distance;
                wizard.direction = Wizard.Direction.BACK;


            }  else if (last.y + distance < wizard.y) {
                wizard.y -= distance;
            } else {
                route.path.remove(last);
                moveByRoute(deltaTime);
            }
        }
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
