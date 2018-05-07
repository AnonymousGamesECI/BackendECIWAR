/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.services.impl;

import edu.eci.arsw.eciwar.model.Player;
import edu.eci.arsw.eciwar.services.GameServices;
import edu.eci.arsw.eciwar.services.ServicesException;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author monitor
 */
//@Service
public class REDISGameServices implements GameServices{

    @Autowired
    private StringRedisTemplate template;
    
    @Override
    public void registerPlayerToRoom(int roomId, Player pl) throws ServicesException {
        if(!template.hasKey(String.valueOf(roomId))){
            throw new ServicesException("Room "+roomId+" not registered in the server.");
        } 
        if(template.opsForSet().isMember(String.valueOf(roomId), String.valueOf(pl.getId()))){
            throw new ServicesException("Player "+pl.getId()+" is already registered in room "+roomId);
        }
        template.opsForSet().add(String.valueOf(roomId), String.valueOf(pl.getId()));
    }

    @Override
    public void removePlayerFromRoom(int roomId, Player pl) throws ServicesException {
        if(!template.hasKey(String.valueOf(roomId))){
            throw new ServicesException("Room "+roomId+" not registered in the server.");
        } 
        if(!template.opsForSet().isMember(String.valueOf(roomId), String.valueOf(pl.getId()))){
            throw new ServicesException("Player "+pl.getId()+" not registered in room "+roomId);
        }
        template.opsForSet().remove(String.valueOf(roomId), String.valueOf(pl.getId()));
    }

    @Override
    public Set<Player> getRegisteredPlayers(int roomId) throws ServicesException {
        if(!template.hasKey(String.valueOf(roomId))){
            throw new ServicesException("Room "+roomId+" not registered in the server.");
        } 
        Set<String> players = template.opsForSet().members(String.valueOf(roomId));
        players.remove("");
        Set<Player> setOfPlayers = new ConcurrentSkipListSet();
        for(String i: players){
            System.out.println(i);
            setOfPlayers.add(new Player(Integer.valueOf(i)));
        }
        return setOfPlayers;
    }

    @Override
    public void createRoom(int roomId) throws ServicesException {
        template.opsForSet().add(String.valueOf(roomId), "");
    }

    @Override
    public void removeRoom(int roomId) throws ServicesException {
        if(!template.hasKey(String.valueOf(roomId))){
            throw new ServicesException("Room "+roomId+" not registered in the server.");
        } 
        template.delete(String.valueOf(roomId));
    }
    
}