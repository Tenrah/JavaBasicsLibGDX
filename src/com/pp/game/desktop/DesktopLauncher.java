package com.pp.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pp.game.cpDriving;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = 
                        new LwjglApplicationConfiguration();
                config.title = "cpDriving";
                config.width = 800;
                config.height = 600;
                config.resizable = false;
                config.useGL30 = true;
		new LwjglApplication(new cpDriving(), config);
	}
}
