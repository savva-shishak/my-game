package com.mygdx.game.impl.main;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.landscape.LandScapeModule;
import com.mygdx.game.impl.targetcell.TargetCellModule;
import com.mygdx.game.impl.wizard.WizardModule;

public class MainModule extends ModuleAdapter {
    private final World world;

    public MainModule(World world) {
        this.world = world;
    }

    @Override
    public void beforeInit() {
        children.add(new LandScapeModule(world));
        children.add(new TargetCellModule(world));
        children.add(new WizardModule(world));
    }
}
