/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.controller;

import edu.eci.arsw.eciwar.model.Player;
import edu.eci.arsw.eciwar.services.GameServices;
import edu.eci.arsw.eciwar.services.ServicesException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    private GameServices services;
    
    @RequestMapping(path = "/{roomId}/players",method = RequestMethod.GET)
    public ResponseEntity<?> getRoomPlayers(@PathVariable(name = "roomId") String roomId) {

         try {
             return new ResponseEntity<>(services.getRegisteredPlayers(Integer.parseInt(roomId)),HttpStatus.ACCEPTED);
         } catch (ServicesException ex) {
             Logger.getLogger(EciWarRESTController.class.getName()).log(Level.SEVERE, null, ex);
             return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.NOT_FOUND);
         } catch (NumberFormatException ex){
             Logger.getLogger(EciWarRESTController.class.getName()).log(Level.SEVERE, null, ex);
             return new ResponseEntity<>("/{roomId}/ must be an integer value.",HttpStatus.BAD_REQUEST);
         }
     }
    
    @RequestMapping(path = "/{roomId}/players",method = RequestMethod.PUT)
    public ResponseEntity<?> addPlayer(@PathVariable(name = "roomId") String roomId,@RequestBody Player pl) {
        try {
            services.registerPlayerToRoom(Integer.parseInt(roomId), pl);
                    return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServicesException ex) {
            Logger.getLogger(EciWarRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        } catch (NumberFormatException ex){
            Logger.getLogger(EciWarRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("/{roomId}/ must be an integer value.",HttpStatus.BAD_REQUEST);
        }

    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createNewRoom(@RequestBody Map<String,String> room) {
        try {
            //System.out.println(Integer.parseInt(room.get("id")));
            services.createRoom(Integer.parseInt(room.get("id")));
                    return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServicesException ex) {
            Logger.getLogger(EciWarRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        } catch (NumberFormatException ex){
            Logger.getLogger(EciWarRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("/{roomId}/ must be an integer value.",HttpStatus.BAD_REQUEST);
        }

    }
    
    @RequestMapping(path = "/{roomId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeRoom(@PathVariable(name = "roomId") String roomId) {
        try {
            services.removeRoom(Integer.parseInt(roomId));
                    return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServicesException ex) {
            Logger.getLogger(EciWarRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        } catch (NumberFormatException ex){
            Logger.getLogger(EciWarRESTController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("/{roomId}/ must be an integer value.",HttpStatus.BAD_REQUEST);
        }

    }
}
