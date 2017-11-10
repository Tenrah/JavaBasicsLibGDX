/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pp.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.pp.gameobjects.OtherCars;
import com.pp.gameobjects.PlayerCar;
import com.pp.gameobjects.Road;
import com.pp.gameobjects.Scrolling;
import com.pp.helpers.Assets;

/**
 *
 * @author Teemu Ihalainen
 */
public class GameRenderer {
    
    private GameWorld world;
    private OrthographicCamera cam;
    
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    
    private PlayerCar playerCar;
    private Scrolling scroller;
    private Road road1, road2;
    private OtherCars car1, car2, car3, car4;//, car5, car6;
    
    private TextureRegion roadTex, playerCarTex, otherCarsTex;
    private BitmapFont font, smallerFont;
    
    public GameRenderer(GameWorld world) {
        
        this.world = world;
        
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 800, 600);
        
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        
        // init Game objects
        playerCar = this.world.getPlayerCar();
        scroller = this.world.getScroller();
        
        road1 = scroller.getRoad1();
        road2 = scroller.getRoad2();
        
        car1 = scroller.getCar1();
        car2 = scroller.getCar2();
        car3 = scroller.getCar3();
        car4 = scroller.getCar4();
        /*car5 = scroller.getCar5();
        car6 = scroller.getCar6();
        */
        // init Assets
        playerCarTex = Assets.playerCar;
        otherCarsTex = Assets.otherCars;
        roadTex = Assets.road;
        font = Assets.font;
        smallerFont = Assets.smallerFont;
    }
    
    public void render() {
        
        // Drawing black background to prevent possible flickering
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batcher.begin();
        
        batcher.disableBlending();
        batcher.draw(roadTex, road1.getX(), road1.getY(), road1.getWidth(), 
                road1.getHeight());
        batcher.draw(roadTex, road2.getX(), road2.getY(), road2.getWidth(), 
                road2.getHeight());
        
        batcher.enableBlending();
        batcher.draw(playerCarTex, playerCar.getX(), playerCar.getY(), 
                playerCar.getWidth(), playerCar.getHeight());
        
        batcher.draw(otherCarsTex, car1.getX(), car1.getY(), 
                car1.getWidth(), car1.getHeight());
        
        batcher.draw(otherCarsTex, car2.getX(), car2.getY(), 
                car2.getWidth(), car2.getHeight());
        
        batcher.draw(otherCarsTex, car3.getX(), car3.getY(), 
                car3.getWidth(), car3.getHeight());
        
        batcher.draw(otherCarsTex, car4.getX(), car4.getY(), 
                car4.getWidth(), car4.getHeight());
        
        /*batcher.draw(otherCarsTex, car5.getX(), car5.getY(), 
                car5.getWidth(), car5.getHeight());
        
        batcher.draw(otherCarsTex, car6.getX(), car6.getY(), 
                car6.getWidth(), car6.getHeight());
        */
        
        smallerFont.draw(batcher, "Goal: " + playerCar.getGoal(), 20, 15);
        smallerFont.draw(batcher, "Traveled: " + 
                (int) playerCar.getJourney(), 20, 35);
        
        // when game is in READY state draw below text
        if(world.isReady()) {
            
            font.draw(batcher, "Start game with SPACE", 250, 150);
        }
        // when game is in GAME OVER state draw below text
        else if(world.isGameOver()) {
                            
            font.draw(batcher, "Game Over", 250, 150);
            font.draw(batcher, "Try again?", 250, 175);

        }
        
        else {
            // when game is in FINISHED state draw below text
            if(world.isGameFinished()) {
                
                font.draw(batcher, "You have reached your", 200, 150);
                font.draw(batcher, "destination safely!", 200, 175);
            }
        }
        
        batcher.end();
        
        /* Code for making collision testing easier
           Draws black boxes over all the cars and both sides of the road
        
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(playerCar.getCollisionRect().x, 
                playerCar.getCollisionRect().y, 
                playerCar.getCollisionRect().width, 
                playerCar.getCollisionRect().height);
        
        shapeRenderer.rect(car1.getCollisionRect().x, 
                car1.getCollisionRect().y, 
                car1.getCollisionRect().width, 
                car1.getCollisionRect().height);
        shapeRenderer.rect(car2.getCollisionRect().x, 
                car2.getCollisionRect().y, 
                car2.getCollisionRect().width, 
                car2.getCollisionRect().height);
        shapeRenderer.rect(car3.getCollisionRect().x, 
                car3.getCollisionRect().y, 
                car3.getCollisionRect().width, 
                car3.getCollisionRect().height);
        shapeRenderer.rect(car4.getCollisionRect().x, 
                car4.getCollisionRect().y, 
                car4.getCollisionRect().width, 
                car4.getCollisionRect().height);
        shapeRenderer.rect(car5.getCollisionRect().x, 
                car5.getCollisionRect().y, 
                car5.getCollisionRect().width, 
                car5.getCollisionRect().height);
        shapeRenderer.rect(car6.getCollisionRect().x, 
                car6.getCollisionRect().y, 
                car6.getCollisionRect().width, 
                car6.getCollisionRect().height);
        
        shapeRenderer.rect(road1.getCollisionRectUp().x, 
                road1.getCollisionRectUp().y, 
                road1.getCollisionRectUp().width, 
                road1.getCollisionRectUp().height);
        shapeRenderer.rect(road1.getCollisionRectDown().x, 
                road1.getCollisionRectDown().y, 
                road1.getCollisionRectDown().width, 
                road1.getCollisionRectDown().height);
        shapeRenderer.rect(road2.getCollisionRectUp().x, 
                road2.getCollisionRectUp().y, 
                road2.getCollisionRectUp().width, 
                road2.getCollisionRectUp().height);
        shapeRenderer.rect(road2.getCollisionRectDown().x, 
                road2.getCollisionRectDown().y, 
                road2.getCollisionRectDown().width, 
                road2.getCollisionRectDown().height);
        shapeRenderer.end();
        */
    }
}
