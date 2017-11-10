/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pp.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.pp.gameobjects.PlayerCar;
import com.pp.gameworld.GameWorld;

/**
 *
 * @author Teemu Ihalainen
 */
public class Inputs implements InputProcessor {
    
    private PlayerCar playerCar;
    private GameWorld world;
    
    public Inputs(GameWorld world) {
        
        this.world = world;
        this.playerCar = this.world.getPlayerCar();
    }

    @Override
    public boolean keyDown(int keycode) {
        
        if(keycode == Input.Keys.SPACE) {
            if(world.isReady()) {
                world.start();
            }
            
            if(world.isGameOver() || world.isGameFinished()) {
                world.restart();
            }
        }
        
        if(keycode == Input.Keys.UP) {
            playerCar.setMovingUp(true);
        }
        
        if(keycode == Input.Keys.DOWN) {
            playerCar.setMovingDown(true);
        }
        
        if(keycode == Input.Keys.LEFT) {
            playerCar.setMovingLeft(true);
        }
        
        if(keycode == Input.Keys.RIGHT) {
            playerCar.setMovingRight(true);
        }
        
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        
        if(keycode == Input.Keys.UP) {
            playerCar.setMovingUp(false);
        }
        
        if(keycode == Input.Keys.DOWN) {
            playerCar.setMovingDown(false);
        }
        
        if(keycode == Input.Keys.LEFT) {
            playerCar.setMovingLeft(false);
        }
        
        if(keycode == Input.Keys.RIGHT) {
            playerCar.setMovingRight(false);
        }
        
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, 
            int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    
    
}
