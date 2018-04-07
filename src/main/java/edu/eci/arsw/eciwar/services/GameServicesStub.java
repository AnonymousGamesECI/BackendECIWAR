/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.services;

import edu.eci.arsw.eciwar.model.Player;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class GameServicesStub implements GameServices{
    ConcurrentHashMap<Integer, Set<Player>> roomsData = new ConcurrentHashMap<>();
    
    public GameServicesStub(){
        roomsData.put(1, new ConcurrentSkipListSet<>());
    }

    @Override
    public void registerPlayerToRoom(int roomId, Player pl) throws ServicesException {
        if (!roomsData.containsKey(roomId)){
            throw new ServicesException("Room "+roomId+" not registered in the server.");
        }
        else{
            if (roomsData.get(roomId).contains(pl)){
                throw new ServicesException("Player "+pl.getId()+" already registered in room "+roomId);
            }
            else{
                roomsData.get(roomId).add(pl);
            }
            
        }
    }

    @Override
    public void removePlayerFromRoom(int roomId, Player pl) throws ServicesException {
        if (!roomsData.containsKey(roomId)){
            throw new ServicesException("Room "+roomId+" not registered in the server.");
        }
        else{
            if (!roomsData.get(roomId).contains(pl)){
                throw new ServicesException("Player "+pl.getId()+" not registered in room "+roomId);
            }
            else{
                roomsData.get(roomId).remove(pl);
            }            
        }
    }

    @Override
    public Set<Player> getRegisteredPlayers(int roomId) throws ServicesException {
        return roomsData.get(roomId);
    }
    
}
