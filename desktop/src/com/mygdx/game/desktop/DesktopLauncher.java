package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		MyGdxGame game = new MyGdxGame();

		config.height = game.getDisplay().getHeight();
		config.width = game.getDisplay().getWidth();

		new LwjglApplication(game, config);
	}
}
