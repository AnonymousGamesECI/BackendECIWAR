/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.collabpaint.controller;

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
    SimpMessagingTemplate msgt;
    
    @MessageMapping("/room.{roomId}/movement")
    public void handleRoomMovementEvent(@DestinationVariable String roomId) throws Exception {
        //Falta implementar
    }
    
    @MessageMapping("/room.{roomId}/newshot")
    public void handleRoomNewShotEvent(@DestinationVariable String roomId) throws Exception {
        //Falta implementar
    }
}


