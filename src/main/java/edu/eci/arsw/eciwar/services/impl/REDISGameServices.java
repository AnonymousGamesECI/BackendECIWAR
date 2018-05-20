/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.services.impl;

import edu.eci.arsw.eciwar.model.Player;
import edu.eci.arsw.eciwar.services.GameServices;
import edu.eci.arsw.eciwar.services.ServicesException;
import java.util.ArrayList;
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
public class REDISGameServices implements GameServices {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void registerPlayerToRoom(int roomId, Player pl) throws ServicesException {
        if (!template.hasKey(String.valueOf(roomId))) {
            throw new ServicesException("Room " + roomId + " not registered in the server.");
        }
        if (template.opsForSet().isMember(String.valueOf(roomId), String.valueOf(pl.getId()))) {
            throw new ServicesException("Player " + pl.getId() + " is already registered in room " + roomId);
        }

        if (template.opsForSet().members(String.valueOf(roomId)).size() == 3) {
            throw new ServicesException("Room " + roomId + " game has already start ");
        }
        template.opsForSet().add(String.valueOf(roomId), String.valueOf(pl.getId()));
        template.opsForSet().add("P:" + pl.getId(), String.valueOf(pl.getX()), String.valueOf(pl.getY()));
    }

    @Override
    public void removePlayerFromRoom(int roomId, Player pl) throws ServicesException {
        if (!template.hasKey(String.valueOf(roomId))) {
            throw new ServicesException("Room " + roomId + " not registered in the server.");
        }
        if (!template.opsForSet().isMember(String.valueOf(roomId), String.valueOf(pl.getId()))) {
            throw new ServicesException("Player " + pl.getId() + " not registered in room " + roomId);
        }
        template.opsForSet().remove(String.valueOf(roomId), String.valueOf(pl.getId()));
        template.opsForSet().remove("P:" + pl.getId(), String.valueOf(pl.getX()), String.valueOf(pl.getY()));
    }

    @Override
    public Set<Player> getRegisteredPlayers(int roomId) throws ServicesException {
        if (!template.hasKey(String.valueOf(roomId))) {
            throw new ServicesException("Room " + roomId + " not registered in the server.");
        }
        template.opsForSet().remove(String.valueOf(roomId), "");
        Set<String> players = template.opsForSet().members(String.valueOf(roomId));
        Set<Player> setOfPlayers = new ConcurrentSkipListSet();

        for (String i : players) {
            ArrayList<String> pos = new ArrayList();
            for (String positions : template.opsForSet().members("P:"+String.valueOf(i))) {
                pos.add(positions);
            }
            setOfPlayers.add(new Player(Integer.valueOf(i), Float.valueOf(pos.get(0)), Float.valueOf(pos.get(1))));
        }

        return setOfPlayers;
    }

    @Override
    public void createRoom(int roomId) throws ServicesException {
        template.opsForSet().add(String.valueOf(roomId), "");
        template.opsForSet().add("rooms", String.valueOf(roomId));
    }

    @Override
    public void removeRoom(int roomId) throws ServicesException {
        if (!template.hasKey(String.valueOf(roomId))) {
            throw new ServicesException("Room " + roomId + " not registered in the server.");
        }
        template.delete(String.valueOf(roomId));
        template.opsForSet().remove("rooms", String.valueOf(roomId));
    }

    @Override
    public int getTotalRooms() throws ServicesException {
        return template.opsForSet().members("rooms").size();
    }

}
