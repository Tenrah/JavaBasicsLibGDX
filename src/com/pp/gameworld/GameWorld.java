/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pp.gameworld;

import com.badlogic.gdx.math.Vector2;
import com.pp.gameobjects.PlayerCar;
import com.pp.gameobjects.Scrolling;

/**
 *
 * @author Teemu Ihalainen
 */
public class GameWorld {
    
    private PlayerCar playerCar;
    private Vector2 startingPos;
    private Scrolling scroller;
    
    private GameState currentState;
    
    public enum GameState {
        READY, RUNNING, GAMEOVER, FINISHED
    }
    
    public GameWorld() {
        
        startingPos = new Vector2(50, 400);
        playerCar = new PlayerCar(startingPos.x, startingPos.y, 120, 70);
        scroller = new Scrolling();
        currentState = GameState.READY;
    }
    
    public void update(float f) {
        
        switch(currentState) {
            case READY:
                updateReady(f);
                break;
            
            case RUNNING:
                updateRunning(f);
            default:
                break;
        }
    }
    
    private void updateReady(float f) {
        
        // could make some additions to code for example
        // make road scrolling in READY STATE as well
    }
    
    public void updateRunning(float f) {
        
        // f cap to make sure collision detection won't break
        // if game takes too long to update
        if(f > .15f) {
            
            f = .15f;
        }
        
        playerCar.movement(f);
        scroller.update(f);
        playerCar.setJourney((float) (playerCar.getJourney() + 0.06));
        
        if(scroller.collides(playerCar)) {
            
            scroller.stop();
            playerCar.die();
            currentState = GameState.GAMEOVER;
        }
        
        if(playerCar.getJourney() >= playerCar.getGoal()) {
            scroller.stop();
            currentState = GameState.FINISHED;
        }
    }
    
    public void start() {
        currentState = GameState.RUNNING;
    }
    
    public void restart() {
        currentState = GameState.READY;
        playerCar.onRestart(startingPos.x, startingPos.y);
        scroller.onRestart();
        
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }
    
    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
    
    public boolean isGameFinished() {
        return currentState == GameState.FINISHED;
    }

    public PlayerCar getPlayerCar() {
        return playerCar;
    }
    
    public Scrolling getScroller() {
        return scroller;
    }
}
