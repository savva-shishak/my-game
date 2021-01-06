package com.mygdx.game.impl.targetcell;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.main.World;

public class TargetCellModule extends ModuleAdapter {
    private World world;

    public TargetCellModule(World world) {
        this.world = world;
    }

    @Override
    protected void beforeInit() {
        TargetCell cell = new TargetCell();

        scripts.add(new TargetCellScript(cell, world));
        views.add(new TargetCellView(cell));
    }
}
