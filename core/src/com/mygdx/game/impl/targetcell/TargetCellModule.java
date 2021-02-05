package com.mygdx.game.impl.targetcell;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.impl.wizard.Wizard;

public class TargetCellModule extends ModuleAdapter {
    private final World world;

    private TargetCell model;
    private Route route;

    private NavigatorScript navigatorScript;


    public TargetCellModule(World world) {
        this.world = world;
    }

    @Override
    protected void beforeInit() {
        model = new TargetCell();
        route = new Route(model);

        navigatorScript = new NavigatorScript(route, world, model);

        scripts.add(navigatorScript);

        views.add(new TargetCellView(model, route));
    }

    public Route getRoute() {
        return route;
    }

    public void setWizard(Wizard wizard) {
        navigatorScript.setWizard(wizard);
    }
}
