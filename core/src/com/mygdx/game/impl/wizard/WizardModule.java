package com.mygdx.game.impl.wizard;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.impl.targetcell.Route;

public class WizardModule extends ModuleAdapter {
    private final World world;
    private final Wizard wizard;
    private final Route route;

    public WizardModule(World world, Wizard wizard, Route route) {
        this.world = world;
        this.wizard = wizard;
        this.route = route;
    }

    @Override
    protected void beforeInit() {

        views.add(new WizardView(wizard));
        scripts.add(new WizardScript(wizard, world, route));
    }
}
