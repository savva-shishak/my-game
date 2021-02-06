package com.mygdx.game.impl.targetcell;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.impl.city.Block;
import com.mygdx.game.impl.city.City;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.impl.wizard.Wizard;
import com.mygdx.game.interfaces.Display;
import com.mygdx.game.interfaces.Script;
import volnovoialgoritm.Navigate;
import volnovoialgoritm.Point;
import volnovoialgoritm.Valid;

public class NavigatorScript implements Script, Valid {
    private final Route route;
    private final World world;

    private final TargetCell targetCell;
    private final Wizard wizard;
    private final City city;

    public NavigatorScript(Route route, World world, TargetCell targetCell, Wizard wizard, City city) {
        this.route = route;
        this.world = world;
        this.targetCell = targetCell;
        this.wizard = wizard;
        this.city = city;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            calcTargetCell();
            setRoute();
        }

        if (targetCell.isView && route.path.size() == 0) {
            targetCell.isView = false;
        }
    }

    private void calcTargetCell() {
        Display display = world.getDisplay();

        int xInput = Gdx.input.getX();
        int yInput = display.getHeight() - Gdx.input.getY();

        OrthographicCamera camera = world.camera;
        targetCell.x = (int) ((xInput * camera.viewportWidth / display.getWidth()) + (camera.position.x - camera.viewportWidth / 2));
        targetCell.y = (int) ((yInput * camera.viewportHeight / display.getHeight()) + (camera.position.y - camera.viewportHeight / 2));
    }

    public void setRoute() {
        Point start = new Point((int) (wizard.x + 0.5), (int) (wizard.y + 0.5));
        Point finish = new Point(targetCell.x, targetCell.y);

        int [][] map = Navigate.propagation(start, finish, (int) world.width, (int) world.height, this);

        if (map[targetCell.x][targetCell.y] != 0) {
            targetCell.isView = true;
            route.path = Navigate.immersion(map, finish, (int) world.width, (int) world.height);
            route.path.remove(route.path.size() - 1);
        }
    }

    @Override
    public boolean isValid(int x, int y) {
        for (Block block: city.getBlocks()) {
            if (block.x == x && block.y == y) {
                return false;
            }
        }

        return true;
    }
}
