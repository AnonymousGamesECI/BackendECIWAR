/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.controller;

import edu.eci.arsw.eciwar.model.Bullet;
import edu.eci.arsw.eciwar.model.Player;
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
    
    
    @MessageMapping("/room.{roomId}/movement")
    public void handleRoomMovementEvent(@DestinationVariable String roomId) throws Exception {
        //Falta implementar
    }
    
    
    @MessageMapping("/room.{roomId}/newshot")
    public void handleBulletEvent(Bullet bullet, @DestinationVariable String roomId) throws Exception{
        
    }
    
    @MessageMapping("/room.{roomId}/newdead")
    public void handleImpactEvent(Player target,@DestinationVariable String roomId) throws Exception{
        msgt.convertAndSend("/room."+roomId+"/dead", target);
        /*
        System.out.println("Nuevo punto recibido en el servidor!:"+pt);
                msgt.convertAndSend("/topic/newpoint."+numdibujo, pt);
                
                
                if(vertices.containsKey(numdibujo)){
                    vertices.get(numdibujo).add(pt);
                    if(vertices.get(numdibujo).size()>=4){
                        msgt.convertAndSend("/topic/newpolygon."+numdibujo, vertices.get(numdibujo));
                        System.out.println("Poligono enviado :"+ vertices.get(numdibujo));
                        vertices.get(numdibujo).clear();
                    }
                }
                else{
                    List<Point> puntos= Collections.synchronizedList( new ArrayList<Point>());
                    puntos.add(pt);
                    vertices.put(numdibujo, puntos);
                }*/
    }
}


