package com.mygdx.game.impl.main;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.city.CityModule;
import com.mygdx.game.impl.landscape.LandScapeModule;
import com.mygdx.game.impl.targetcell.TargetCellModule;
import com.mygdx.game.impl.wizard.WizardModule;

public class MainModule extends ModuleAdapter {
    private final World world;

    Context context;

    public MainModule(World world) {
        this.world = world;
    }

    @Override
    public void beforeInit() {
        context = new Context(world);

        children.add(new LandScapeModule(world));
        children.add(new TargetCellModule(world, context.route, context.wizard, context.targetCell, context.city));
        children.add(new CityModule(context.city));
        children.add(new WizardModule(world, context.wizard, context.route));
    }
}
