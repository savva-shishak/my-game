package com.mygdx.game.impl.wizard;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.main.World;

public class WizardModule extends ModuleAdapter {
    private final World world;

    public WizardModule(World world) {
        this.world = world;
    }

    @Override
    protected void beforeInit() {
        Wizard wizard = new Wizard();

        views.add(new WizardView(wizard));
        scripts.add(new WizardScript(wizard, world));
    }
}
