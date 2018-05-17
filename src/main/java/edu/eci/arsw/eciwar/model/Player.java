/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 *
 * @author USER
 */
public class Player implements Comparable<Player> {

    private int id;
    private float x, y, rotation;
    private Vector position;
    public Player() {
    }

    public Player(int id) {
        this.id = id;
    }

    public Player(int id, float x, float y, float rotation, Vector position) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.position = position;
    }

    public Player(Integer valueOf, String get, String get0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    

    
    
    

    /*@Override
    public String toString(){
        return ('Player{' + ' id=' + this.id +  ', x=' + this.x + ', y=' + this.y + ', rt=' + this.rt + '}');
    }*/
    @Override
    public int compareTo(Player o) {
        return o.getId() - this.getId();
    }

}
