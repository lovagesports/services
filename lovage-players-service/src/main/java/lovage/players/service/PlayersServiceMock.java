package lovage.players.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang.StringUtils;

import lovage.domain.Player;
import lovage.security.users.IUsersService;
import lovage.utils.KeyUtils;

@Stateless
public class PlayersServiceMock extends PlayersServiceBase implements IPlayersService {

	@EJB
	private IUsersService usersService;

	private Map<Long, Player> players;

	@PostConstruct
	public void init() {
		System.out.println("Started PlayersServiceMock implementation for IPlayersService.");

		players = usersService.getPlayers();
	}

	@Override
	public Player getPlayer(Long id) {
		Player player = players.get(id);
		return player;
	}

	@Override
	public Player getPlayer(String email) {
		Player found = players.values().stream().filter(item -> StringUtils.equals(email, item.email)).findFirst()
				.orElse(null);

		return found;
	}

	@Override
	public List<Player> getMinPlayers() {
		List<Player> result = new ArrayList<Player>();
		for (Entry<Long, Player> entry : players.entrySet()) {

			Player copy = new Player();
			copy.id = entry.getValue().id;
			copy.name = entry.getValue().name;
			result.add(copy);
		}

		return result;
	}

	@Override
	public boolean create(Player player) {

		if (player == null) {
			return false;
		}

		if (player.id == null) {
			player.id = KeyUtils.nextLong(players.keySet());
		}

		players.put(player.id, player);

		return true;
	}
}
