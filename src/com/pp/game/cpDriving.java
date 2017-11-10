package com.pp.game;

import com.badlogic.gdx.Game;
import com.pp.helpers.Assets;
import com.pp.screens.GameScreen;

public class cpDriving extends Game {
	
	@Override
	public void create () {
            
            Assets.load();
            setScreen(new GameScreen());
	}
        
        @Override
        public void dispose() {
            super.dispose();
            Assets.dispose();
        }
}
