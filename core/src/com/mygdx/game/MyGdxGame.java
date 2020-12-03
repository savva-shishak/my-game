package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.impl.DisplayImpl;
import com.mygdx.game.impl.main.MainModule;
import com.mygdx.game.impl.main.World;
import com.mygdx.game.interfaces.Display;
import com.mygdx.game.interfaces.Module;

public class MyGdxGame extends Game {
	private final Display display = new DisplayImpl(800, 480);

	World world;
	Module main;
	SpriteBatch batch;
	
	@Override
	public void create () {
		world = new World(display.getWidth(), display.getHeight());
		main = new MainModule(world);

		batch = new SpriteBatch();

		main.init();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.render(batch);

		batch.begin();
		main.render(batch);
		batch.end();

		main.update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
		world.resize(width, height);
	}

	@Override
	public void dispose () {
		batch.dispose();
		main.dispose();
	}

	public Display getDisplay() {
		return display;
	}
}
