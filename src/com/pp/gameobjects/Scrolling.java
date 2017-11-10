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
public class Scrolling {
    
    private Road road1, road2;
    private OtherCars car1, car2, car3, car4;//, car5, car6;
    
    public static final int GAP = 80;
    public static final int SCROLL_SPEED = -500;
    
    public Scrolling() {
        
        road1 = new Road(0, 0, 800, 600, SCROLL_SPEED+200);
        road2 = new Road(road1.getTailX(), 0, 800, 600, SCROLL_SPEED+200);
        
        car1 = new OtherCars(810, 510, 120, 70, SCROLL_SPEED);
        car2 = new OtherCars(car1.getTailX() + GAP, 430 + GAP, 120, 70, 
                SCROLL_SPEED);
        car3 = new OtherCars(car2.getTailX() + GAP * 2, 340 + GAP, 120, 70, 
                SCROLL_SPEED);
        car4 = new OtherCars(car3.getTailX() + GAP, 270 + GAP, 120, 70, 
                SCROLL_SPEED);
        /*car5 = new OtherCars(car4.getTailX() + GAP, 100 + GAP, 120, 70, 
                SCROLL_SPEED);
        car6 = new OtherCars(car5.getTailX() + GAP, 10 + GAP, 120, 70, 
                SCROLL_SPEED);*/
        
    }
    
    public void update(float f) {
        
        road1.update(f);
        road2.update(f);
        
        car1.update(f);
        car2.update(f);
        car3.update(f);
        car4.update(f);
        //car5.update(f);
        //car6.update(f);
        
        // resetting cars and roads when scrolled out of screen
        if(car1.isScrolledLeft()) {
            
            // giving starter X value, and random range (same for others below)
            car1.reset(810, 220, 300);
        }
        
        if(car2.isScrolledLeft()) {
            car2.reset(810, 520, 1);
        }
        
        if(car3.isScrolledLeft()) {
            car3.reset(810, 180, 1);
        }
        
        if(car4.isScrolledLeft()) {
            car4.reset(810, 520, 1);
        }
        /*
        if(car5.isScrolledLeft()) {
            car5.reset(810);
        }
        
        if(car6.isScrolledLeft()) {
            car6.reset(810);
        }
        */
        if(road1.isScrolledLeft()) {
            road1.reset(road2.getTailX(), 0, 0);
        }
        
        if(road2.isScrolledLeft()) {
            road2.reset(road1.getTailX(), 0, 0);
        }
    }
    
    // restarting roads and other cars
    public void onRestart() {
        
        road1.onRestart(0, SCROLL_SPEED + 200);
        road2.onRestart(road1.getTailX(), SCROLL_SPEED + 200);
        
        car1.onRestart(810, SCROLL_SPEED);
        car2.onRestart(car1.getTailX() + GAP * 2, SCROLL_SPEED);
        car3.onRestart(car2.getTailX() + GAP, SCROLL_SPEED);
        car4.onRestart(car3.getTailX() + GAP, SCROLL_SPEED);
    }
    
    // stop scrolling
    public void stop() {
        
        road1.stop();
        road2.stop();
        car1.stop();
        car2.stop();
        car3.stop();
        car4.stop();
        /*car5.stop();
        car6.stop();*/
    }
    
    // Collision detection method for player and other cars
    public boolean collides(PlayerCar playerCar) {
        return (car1.collides(playerCar) || car2.collides(playerCar) ||
                car3.collides(playerCar) || car4.collides(playerCar) /*||
                car5.collides(playerCar) || car6.collides(playerCar)*/);
    }

    public Road getRoad1() {
        return road1;
    }

    public Road getRoad2() {
        return road2;
    }

    public OtherCars getCar1() {
        return car1;
    }

    public OtherCars getCar2() {
        return car2;
    }

    public OtherCars getCar3() {
        return car3;
    }

    public OtherCars getCar4() {
        return car4;
    }
/*
    public OtherCars getCar5() {
        return car5;
    }

    public OtherCars getCar6() {
        return car6;
    }*/
}
