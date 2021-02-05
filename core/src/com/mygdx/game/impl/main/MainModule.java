package com.mygdx.game.impl.main;

import com.mygdx.game.impl.adapters.ModuleAdapter;
import com.mygdx.game.impl.landscape.LandScapeModule;
import com.mygdx.game.impl.targetcell.TargetCellModule;
import com.mygdx.game.impl.wizard.WizardModule;

public class MainModule extends ModuleAdapter {
    private final World world;

    WizardModule wizard;
    TargetCellModule targetCell;

    public MainModule(World world) {
        this.world = world;
    }

    @Override
    public void beforeInit() {
        LandScapeModule landScape   = new LandScapeModule(world);
        wizard         = new WizardModule(world);
        targetCell = new TargetCellModule(world);


        children.add(landScape);
        children.add(targetCell);
        children.add(wizard);
    }

    @Override
    public void init() {
        super.init();

        wizard.setRoute(targetCell.getRoute());
        targetCell.setWizard(wizard.getModel());
    }
}
