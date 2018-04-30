/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.controller;

import edu.eci.arsw.eciwar.model.Bullet;
import edu.eci.arsw.eciwar.model.Player;
import edu.eci.arsw.eciwar.model.Prueba;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author USER
 */
@Controller
public class STOMPMessagesHandler {
    
    @Autowired
    private SimpMessagingTemplate msgt;
    
    private ConcurrentMap<String,List> players = new ConcurrentHashMap<>();
    
    
    @MessageMapping("/start.{roomId}")
    public void handleStartEvent(@DestinationVariable String roomId) throws Exception {
        msgt.convertAndSend("/room." + roomId + "/start", "Nothing");
    }
    
    
    @MessageMapping("/movement.{roomId}")
    public void handleMoveEvent(Player player, @DestinationVariable String roomId) throws Exception{
        msgt.convertAndSend("/room." + roomId + "/movement", player);
    }
    
    @MessageMapping("/newshot.{roomId}")
    public void handleBulletEvent(Bullet bullet,@DestinationVariable String roomId) throws Exception{
        //System.out.println(bullet.getIdShooter()+"------------"+bullet.getPosition().getX()+","+bullet.getPosition().getY()+"------------TX: "+bullet.getTouchLocX()+",TY: "+bullet.getTouchLocY());
        msgt.convertAndSend("/room." + roomId + "/newshot", bullet);
    }
    
    @MessageMapping("/newdeath.{roomId}")
    public void handleDeathEvent(Player player, @DestinationVariable String roomId) throws Exception{
        msgt.convertAndSend("/room." + roomId + "/newdeath", player);
    }
    
    @MessageMapping("/winner.{roomId}")
    public void handleWinnerEvent(Player player, @DestinationVariable String roomId) throws Exception{
        msgt.convertAndSend("/room." + roomId + "/winner", player);
    }
}


