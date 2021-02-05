package com.mygdx.game.impl.targetcell;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.impl.wizard.Wizard;
import com.mygdx.game.interfaces.Script;
import volnovoialgoritm.Navigate;
import volnovoialgoritm.Point;
import volnovoialgoritm.Valid;

import java.util.ArrayList;

public class NavigatorScript implements Script {
    private final Route route;
    private final World world;

    private final TargetCell targetCell;
    private Wizard wizard;

    public NavigatorScript(Route route, World world, TargetCell targetCell) {
        this.route = route;
        this.world = world;
        this.targetCell = targetCell;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float deltaTime) {
        if (targetCell.x == (int) wizard.x && targetCell.y == (int) wizard.y) {
            targetCell.isView = false;
        } else if (targetCell.isView) {
            float distance = 5.0f * deltaTime;

            Point start = new Point((int) wizard.x, (int) wizard.y);
            Point finish = new Point(targetCell.x, targetCell.y);

            int [][] map = Navigate.propagation(start, finish, (int) world.width, (int) world.height, Valid.free);

            if (map[targetCell.x][targetCell.y] != 0) {
                route.path = new ArrayList<>();

                for (Point point : Navigate.immersion(map, finish, (int) world.width, (int) world.height)) {
                    if (
                            (point.x != (int) wizard.x ) && (point.x != (int) wizard.x + distance) ||
                            (
                                    point.x == finish.x &&
                                    (finish.x + distance * 2 < wizard.x ||
                                    finish.x - distance * 2 > wizard.x)

                            )
                    ) {
                        route.path.add(point);
                    }
                }
            } else {
                targetCell.isView = false;
            }
        }

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            route.completed = new ArrayList<>();
        }
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }
}
