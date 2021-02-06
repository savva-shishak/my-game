package com.mygdx.game.impl.main;

import com.mygdx.game.impl.city.City;
import com.mygdx.game.impl.city.Home;
import com.mygdx.game.impl.targetcell.Route;
import com.mygdx.game.impl.targetcell.TargetCell;
import com.mygdx.game.impl.wizard.Wizard;

public class Context {
    public Wizard wizard;
    public TargetCell targetCell;
    public Route route;
    public World world;
    public City city;

    public Context(World world) {
        wizard = new Wizard();
        targetCell = new TargetCell();
        route = new Route();
        this.world = world;

        city = new City();
        city.homes.add(new Home(50, 49));
    }
}
