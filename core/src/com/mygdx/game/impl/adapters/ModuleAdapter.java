package com.mygdx.game.impl.adapters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.interfaces.Module;
import com.mygdx.game.interfaces.Script;
import com.mygdx.game.interfaces.View;

public abstract class ModuleAdapter implements Module {

    protected final Array<Script> scripts = new Array<>();
    protected final Array<View> views = new Array<>();
    protected final Array<Module> children = new Array<>();

    protected void beforeInit() {};

    @Override
    public void init() {
        beforeInit();
        for (Module m : children) {
            m.init();
        }
        for (View v : views) {
            v.init();
        }
    }

    protected void beforeRender(SpriteBatch batch) {}

    @Override
    public final void render(SpriteBatch batch) {
        beforeRender(batch);
        for (Module m : children) {
            m.render(batch);
        }
        for (View v : views) {
            v.render(batch);
        }
    }

    protected void beforeUpdate(float deltaTime) {}

    @Override
    public final void update(float deltaTime) {
        beforeUpdate(deltaTime);
        for (Module m : children) {
            m.update(deltaTime);
        }
        for (Script s : scripts) {
            s.update(deltaTime);
        }
    }

    protected void beforeDispose() {}

    @Override
    public final void dispose() {
        beforeDispose();
        for (Module m : children) {
            m.dispose();
        }
        for (View v : views) {
            v.dispose();
        }
    }
}
