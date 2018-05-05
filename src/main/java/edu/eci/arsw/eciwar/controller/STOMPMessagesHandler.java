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
import org.springframework.messaging.handler.annotation.SendTo;
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
    
    
    @MessageMapping("/start/{roomId}")
    @SendTo("/topic/room-start-{roomId}")
    public String handleStartEvent(@DestinationVariable("roomId") String roomId) throws Exception {
        return "Nothing";
    }
    
    
    @MessageMapping("/movement/{roomId}")
    @SendTo("/topic/room-movement-{roomId}")
    public Player handleMoveEvent(Player player, @DestinationVariable("roomId") String roomId) throws Exception{
        return player;
    }
    
    @MessageMapping("/newshot/{roomId}")
    @SendTo("/topic/room-newshot-{roomId}")
    public Bullet handleBulletEvent(Bullet bullet,@DestinationVariable String roomId) throws Exception{
        return bullet;
    }
    
    @MessageMapping("/newdeath/{roomId}")
    @SendTo("/topic/room-newdeath-{roomId}")
    public Player handleDeathEvent(Player player, @DestinationVariable String roomId) throws Exception{
        return player;
    }
}


