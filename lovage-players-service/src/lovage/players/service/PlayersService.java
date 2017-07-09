package lovage.players.service;

import java.util.List;

import javax.ejb.Stateless;

import lovage.domain.Player;

@Stateless
public class PlayersService implements IPlayersService {

	@Override
	public Player getPlayer(Long idd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getMinPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validate(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player login(Player player) {
		// TODO Auto-generated method stub
		return null;
	}
}
