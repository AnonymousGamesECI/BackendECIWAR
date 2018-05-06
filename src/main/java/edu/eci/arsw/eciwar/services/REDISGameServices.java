/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.services;

import edu.eci.arsw.eciwar.model.Player;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author monitor
 */
@Service
public class REDISGameServices implements GameServices{

    @Autowired
    private StringRedisTemplate template;
    
    @Override
    public void registerPlayerToRoom(int roomId, Player pl) throws ServicesException {
        template.opsForSet().add(String.valueOf(roomId), String.valueOf(pl.getId()));
    }

    @Override
    public void removePlayerFromRoom(int roomId, Player pl) throws ServicesException {
        template.opsForSet().remove(String.valueOf(roomId), String.valueOf(pl.getId()));
    }

    @Override
    public Set<Player> getRegisteredPlayers(int roomId) throws ServicesException {
        Set<String> players = template.opsForSet().members(String.valueOf(roomId));
        Set<Player> setOfPlayers = new ConcurrentSkipListSet();
        for(String i: players){
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
        template.delete(String.valueOf(roomId));
    }
    
}
