/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pp.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.pp.gameworld.GameRenderer;
import com.pp.gameworld.GameWorld;
import com.pp.helpers.Inputs;

/**
 *
 * @author Teemu Ihalainen
 */
public class GameScreen implements Screen {
    
    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen() {
        
        this.world = new GameWorld();
        this.renderer = new GameRenderer(world);
        
        Gdx.input.setInputProcessor(new Inputs(this.world));
    }

    @Override
    public void render(float f) {
        
        world.update(f);
        renderer.render();
    }
    
    @Override
    public void show() {
        
    }

    @Override
    public void resize(int width, int height) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {
        
    }
    
}
