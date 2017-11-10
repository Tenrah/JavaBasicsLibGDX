/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pp.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import java.util.Random;

/**
 *
 * @author Teemu Ihalainen
 */
public class OtherCars extends Scrollable {
    
    private Random rand;
    
    private Rectangle collisionRect;
    
    public OtherCars(float x, float y, int width, int height, 
            float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        
        rand = new Random();
        collisionRect = new Rectangle();
    }
    
    @Override
    public void reset(float newX, int randMod, int randMod2) {
        super.reset(newX, randMod, randMod2);
        
        position.y = rand.nextInt(randMod) + randMod2;
    }
    
    @Override
    public void update(float f) {
        super.update(f);
        
        collisionRect.set(position.x, position.y, this.width, this.height);
    }
    
    public void onRestart(float x, float scrollSpeed) {
        
        velocity.x = scrollSpeed;
        reset(x, 540, 1);
    }
    
    // Collision
    public boolean collides(PlayerCar playerCar) {
        
        if(position.x < playerCar.getX() + playerCar.getWidth()) {
            
            return (Intersector.overlaps(playerCar.getCollisionRect(), 
                    collisionRect));
        }
        
        return false;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }
}
