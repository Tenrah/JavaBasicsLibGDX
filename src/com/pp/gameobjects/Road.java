/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pp.gameobjects;


/**
 *
 * @author Teemu Ihalainen
 */
public class Road extends Scrollable {
    
    /* Collision detection for road edges which I realised is unneeded
       in this case - commented all relevant collision
    private Rectangle collisionRectUp;
    private Rectangle collisionRectDown;*/
    
    public Road(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        
        /*collisionRectUp = new Rectangle();
        collisionRectDown = new Rectangle();*/
    }
    
    @Override
    public void update(float f) {
        super.update(f);
        
        /*collisionRectUp.set(position.x, position.y, this.width, 5);
        collisionRectDown.set(position.x, position.y + Gdx.graphics.getHeight(),
                this.width, -5);*/
    }
    
    // when restart is called X resets and speed goes back to scrollSpeed
    public void onRestart(float x, float scrollSpeed) {
        
        position.x = x;
        velocity.x = scrollSpeed;
    }
    
    /*
    public boolean collides(PlayerCar playerCar) {
        
        if(position.x < playerCar.getX() + playerCar.getWidth()) {
            
            return (Intersector.overlaps(playerCar.getCollisionRect(), 
                    collisionRectUp) || Intersector.overlaps(playerCar.
                            getCollisionRect(), collisionRectDown));
        }
        
        return false; 
    }

    public Rectangle getCollisionRectUp() {
        return collisionRectUp;
    }
    
    public Rectangle getCollisionRectDown() {
        return collisionRectDown;
    }
    */
}
