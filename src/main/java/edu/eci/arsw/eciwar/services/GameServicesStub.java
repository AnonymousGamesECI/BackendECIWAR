/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.eciwar.services;

import edu.eci.arsw.eciwar.model.Player;
import java.util.Set;

/**
 *
 * @author USER
 */
public class GameServicesStub implements GameServices{

    @Override
    public void registerPlayerToRoom(int roomId, Player pl) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePlayerFromRoom(int roomId, Player pl) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Player> getRegisteredPlayers(int roomId) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
