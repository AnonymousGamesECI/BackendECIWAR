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
    private Player shooter;
    private int damage;

    
    public Bullet(Player shooter, int damage){
        this.shooter= shooter;
        this.damage =damage;
    }
}
