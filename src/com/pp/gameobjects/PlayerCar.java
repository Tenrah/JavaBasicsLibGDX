/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pp.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Teemu Ihalainen
 */
public class PlayerCar {
    
    private Vector2 position;
    //private Vector2 acceleration;
    
    private int width;
    private int height;
    
    private Rectangle collisionRect;
    
    private boolean isAlive;
    
    private float journey;
    private int goal;
    
    private boolean movingUp, movingDown, movingLeft, movingRight;
    
    public PlayerCar(float x, float y, int width, int height) {
        
        this.width = width;
        this.height = height;
        
        position = new Vector2(x, y);
        //acceleration = new Vector2(0, 0);
        
        collisionRect = new Rectangle();
        
        isAlive = true;
        
        this.journey = 0;
        this.goal = 100;
        
        movingUp = false;
        movingDown = false;
        movingLeft = false;
        movingRight = false;
    }
    
    public void movement(float f) {
        
        if(isAlive) {
            
            if(movingUp) {
                // making sure that car can't go out of game edges
                if(position.y >= 0) {
                    position.y -= f * 200;
                }
            }

            if(movingDown) {
                // making sure that car can't go out of game edges
                if(position.y <= 530) {
                    position.y += f * 200;
                }
            }

            if(movingLeft) {
                // making sure that car can't go out of game edges
                if(position.x >= 0) {
                    position.x -= f * 200;
                    
                    if(journey > 0) {
                        journey -= 0.01;
                    }
                }
            }
            
            if(movingRight) {
                // making sure that car can't go out of game edges
                if(position.x <= 681) {
                    position.x += f * 200;
                    journey += 0.04;
                }
            }
        }
        collisionRect.set(position.x, position.y, this.width, this.height);
    }
    
    public void onRestart(float startingX, float startingY) {
        
        position.x = startingX;
        position.y = startingY;
        isAlive = true;
        journey = 0;
    }
    
    public void die() {
        
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public float getX() {
        return position.x;
    }
    
    public float getY() {
        return position.y;
    }

    public float getJourney() {
        return journey;
    }

    public void setJourney(float journey) {
        this.journey = journey;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }
}
