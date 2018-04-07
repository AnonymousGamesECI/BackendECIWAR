/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.controller;

import edu.eci.arsw.eciwar.services.GameServices;
import edu.eci.arsw.eciwar.services.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping(value = "/rooms")
public class EciWarRESTController {
    @Autowired
    GameServices services;
    
    @RequestMapping(path = "/{roomId}/players",method = RequestMethod.GET)
    public ResponseEntity<?> getRaceParticipantsNums(@PathVariable(name = "roomId") String roomId) {

         try {
             return new ResponseEntity<>(services.getRegisteredPlayers(Integer.parseInt(roomId)),HttpStatus.ACCEPTED);
         } catch (ServicesException ex) {
             //Logger.getLogger(ClicRaceRESTController.class.getName()).log(Level.SEVERE, null, ex);
             return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.NOT_FOUND);
         } catch (NumberFormatException ex){
             //Logger.getLogger(ClicRaceRESTController.class.getName()).log(Level.SEVERE, null, ex);
             return new ResponseEntity<>("/{roomId}/ must be an integer value.",HttpStatus.BAD_REQUEST);
         }
     }
}
