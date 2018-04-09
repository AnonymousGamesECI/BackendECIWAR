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
public class Player implements Comparable<Player>{
    private int id;
    private float x, y;
    private float rt;
    
    public Player(){
    }
    
    public Player(int id){
        this.id = id;
    }
    
    public Player(int id, float x, float y, float rt){
        this.id = id;
        this.x = x;
        this.y = y;
        this.rt = rt;
    }
    
    public int getId(){ return this.id; }
    
    public void setId(int id){ this.id = id; }
    
    public float getX(){ return this.x; }
    
    public void setX(float x){ this.x = x; }
    
    public float getY(){ return this.y; }
    
    public void setY(float y){ this.y = y; }
    
    public float getRt(){ return this.x; }
    
    public void setRt(float rt){ this.rt = rt; }
    
    /*@Override
    public String toString(){
        return ('Player{' + ' id=' + this.id +  ', x=' + this.x + ', y=' + this.y + ', rt=' + this.rt + '}');
    }*/

    @Override
    public int compareTo(Player o) {
        return o.getId() - this.getId();
    }
    
}
