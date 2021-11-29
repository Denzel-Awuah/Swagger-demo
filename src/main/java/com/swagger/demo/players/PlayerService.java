package com.swagger.demo.players;

import java.util.List;

public interface PlayerService {

	public List<Player> allPlayers();
	
	public Player getPlayerById(long theid);
	
	public void save(Player thePlayer);
	
	public void deletePlayerById(long theId);
}
