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
        String actGame = "room:" + roomId;
        if (!template.hasKey(actGame)) {
            throw new ServicesException("La sala no se encuentra creada.");
        } else {
            template.opsForList().leftPush(actGame + ":players", String.valueOf(pl.getId()));
        }
    }

    @Override
    public void removePlayerFromRoom(int roomId, Player pl) throws ServicesException {
        String actGame = "room:" + roomId;
        if (!template.hasKey(actGame)) {
            throw new ServicesException("La sala no se encuentra creada.");
        } else {
            template.opsForList().remove(actGame + ":players", 1, pl.getId());
        }
    }

    @Override
    public Set<Player> getRegisteredPlayers(int roomId) throws ServicesException {
        String actGame = "room:" + roomId;
        List<String> result = template.opsForList().range(actGame, 0, -1);
        Set<Player> players = new HashSet();
        result.forEach((idPlayer) -> {
            players.add(new Player(Integer.valueOf(idPlayer)));
        });
        return players;
    }

    @Override
    public void createRoom(int roomId) throws ServicesException {
        String actGame = "room:" + roomId;
        if (template.hasKey(actGame)) {
            throw new ServicesException("La sala ya se encuentra creada.");
        } else {
            template.opsForHash().put(actGame, "", "");
        }
    }

    @Override
    public void removeRoom(int roomId) throws ServicesException {
        template.delete("room:"+roomId);
    }
    
}
