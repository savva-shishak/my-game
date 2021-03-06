package com.mygdx.game.impl.targetcell;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.city.City;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.impl.wizard.Wizard;

public class TargetCellModule extends ModuleAdapter {
    private final World world;
    private final Route route;
    private final Wizard wizard;
    private final TargetCell targetCell;
    private final City city;


    public TargetCellModule(World world, Route route, Wizard wizard, TargetCell targetCell, City city) {
        this.world = world;
        this.route = route;
        this.wizard = wizard;
        this.targetCell = targetCell;
        this.city = city;
    }

    @Override
    protected void beforeInit() {
        scripts.add(new NavigatorScript(route, world, targetCell, wizard, city));
        views.add(new TargetCellView(targetCell, route));
    }
}
