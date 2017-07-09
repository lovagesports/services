package lovage.players.service;

import java.util.List;

import lovage.domain.Player;

public interface IPlayersService {

	List<Player> getMinPlayers();

	Player getPlayer(Long id);

	boolean create(Player player);

	boolean validate(Player player);

	Player login(Player player);
}
