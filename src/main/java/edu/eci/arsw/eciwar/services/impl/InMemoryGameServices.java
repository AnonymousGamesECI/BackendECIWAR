/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.services.impl;

import edu.eci.arsw.eciwar.model.Player;
import edu.eci.arsw.eciwar.services.GameServices;
import edu.eci.arsw.eciwar.services.GameServices;
import edu.eci.arsw.eciwar.services.ServicesException;
import edu.eci.arsw.eciwar.services.ServicesException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class InMemoryGameServices implements GameServices{
    private ConcurrentHashMap<Integer, Set<Player>> roomsData;
    
    public InMemoryGameServices(){
        roomsData = new ConcurrentHashMap<>();
        //roomsData.put(1, new ConcurrentSkipListSet<>());
    }

    @Override
    public void registerPlayerToRoom(int roomId, Player pl) throws ServicesException {
        System.out.println(pl.getId()+"-----------------------------ID");
        if (!roomsData.containsKey(roomId)){
            throw new ServicesException("Room "+roomId+" not registered in the server.");
        }
        else{
            if (roomsData.get(roomId).contains(pl)){
                throw new ServicesException("Player "+pl.getId()+" already registered in room "+roomId);
            }
            else{
                if(roomsData.get(roomId).size() == 3){
                    throw new ServicesException("Room " + roomId + " game has already start ");
                }
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
        if(!roomsData.containsKey(roomId)){
            throw new ServicesException("Room "+roomId+" does not exist");
        }
        else{
            return roomsData.get(roomId);
        }
    }
    
    @Override
    public void createRoom(int roomId) throws ServicesException{
        if (roomsData.containsKey(roomId)){
            throw new ServicesException("Room "+roomId+" already registered in the server.");
        }else{
            roomsData.put(roomId, new ConcurrentSkipListSet<>());
        }
    }
    
    @Override
    public void removeRoom(int roomId) throws ServicesException{
        if (!roomsData.containsKey(roomId)){
            throw new ServicesException("Room "+roomId+" not registered in the server.");          
        }else{
            roomsData.remove(roomId);
        }
    }
    
}
