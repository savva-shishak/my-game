package com.mygdx.game.impl.main;

import com.mygdx.game.impl.targetcell.Route;
import com.mygdx.game.impl.targetcell.TargetCell;
import com.mygdx.game.impl.wizard.Wizard;

public class Context {
    public Wizard wizard;
    public TargetCell targetCell;
    public Route route;
    public World world;

    public Context(World world) {
        wizard = new Wizard();
        targetCell = new TargetCell();
        route = new Route();
        this.world = world;
    }
}
