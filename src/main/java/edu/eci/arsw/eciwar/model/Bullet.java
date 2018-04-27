/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.model;

/**
 *
 * @author USER
 */
public class Bullet {
    private int idShooter;
    private int touchLocX, touchLocY;
    private Vector position;
    
    
    
    public Bullet(){}
    

    public int getIdShooter() {
        return idShooter;
    }

    public void setIdShooter(int idShooter) {
        this.idShooter = idShooter;
    }


    public int getTouchLocX() {
        return touchLocX;
    }

    public void setTouchLocX(int touchLocX) {
        this.touchLocX = touchLocX;
    }

    public int getTouchLocY() {
        return touchLocY;
    }

    public void setTouchLocY(int touchLocY) {
        this.touchLocY = touchLocY;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }
    
    
}
