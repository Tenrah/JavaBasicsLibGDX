/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pp.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author Teemu Ihalainen
 */
public class Assets {
    
    public static Texture texture, roadTexture;
    public static TextureRegion playerCar, otherCars, road, road2;
    public static BitmapFont font, smallerFont;
    
    public static void load() {
        
        roadTexture = new Texture(Gdx.files.internal("PPassets/Road.png"));
        roadTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        road = new TextureRegion(roadTexture, 0, 0, 800, 600);
        
        texture = new Texture(Gdx.files.internal("PPassets/Cars.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        playerCar = new TextureRegion(texture, 0, 0, 119, 70);
        otherCars = new TextureRegion(texture, 122, 0, 120, 70);
        
        font = new BitmapFont(Gdx.files.internal("PPassets/default.fnt"));
        font.getData().setScale(1.25f, -1.25f);
        
        smallerFont = new BitmapFont(Gdx.files.internal("PPassets/default.fnt"));
        smallerFont.getData().setScale(1f, -1f);
    }
    
    public static void dispose() {
        
        texture.dispose();
        roadTexture.dispose();
        font.dispose();
    }
}
