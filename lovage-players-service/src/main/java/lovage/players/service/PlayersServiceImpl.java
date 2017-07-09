package lovage.players.service;

import java.util.List;

import javax.ejb.Stateless;

import lovage.domain.Player;

@Stateless
public class PlayersServiceImpl extends PlayersServiceBase implements IPlayersService {

	@Override
	public List<Player> getMinPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

}
