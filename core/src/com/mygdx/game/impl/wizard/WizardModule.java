package com.mygdx.game.impl.wizard;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.impl.targetcell.Route;

public class WizardModule extends ModuleAdapter {
    private final World world;
    private Wizard model;
    private WizardScript script;

    public WizardModule(World world) {
        this.world = world;
    }

    @Override
    protected void beforeInit() {
        Wizard wizard = new Wizard();
        model = wizard;
        script = new WizardScript(wizard, world);

        views.add(new WizardView(wizard));
        scripts.add(script);
    }

    public Wizard getModel() {
        return model;
    }

    public void setRoute(Route route) {
        script.setRoute(route);
    }
}
