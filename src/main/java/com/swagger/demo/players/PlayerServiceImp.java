package com.swagger.demo.players;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImp implements PlayerService{

	@Autowired
	private PlayersRepository repository;
	
	@Override
	public List<Player> allPlayers() {
		return repository.findAll();
	}

	@Override
	public Player getPlayerById(long theid) {
		return repository.getById(theid);
	}

	@Override
	public void save(Player thePlayer) {
		repository.save(thePlayer);
	}

	@Override
	public void deletePlayerById(long theId) {
		repository.deleteById(theId);
	}

}
