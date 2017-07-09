package lovage.players.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.apache.commons.lang.StringUtils;

import lovage.domain.Player;
import lovage.utils.KeyUtils;

@Stateless
public class PlayersServiceMock extends PlayersServiceBase implements IPlayersService {

	private static final Map<Long, Player> players = initMockPlayers();

	@PostConstruct
	public void init() {
		System.out.println("Started PlayersServiceMock implementation for IPlayersService.");
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

	private static Map<Long, Player> initMockPlayers() {
		Map<Long, Player> mockPlayers = new HashMap<Long, Player>();

		try {
			Player player1 = new Player(1L, "Dorin Mateiu", "dorin.mateiu@lovage.ro", "test", "05/05/2985");
			mockPlayers.put(player1.id, player1);
		} catch (Exception e) {
			System.out.println(e);
		}

		Player player2 = new Player(2L, "Cosmin Haiducu", "cosmin.haiducu@lovage.ro", "test", "22/12/1990");
		mockPlayers.put(player2.id, player2);

		return mockPlayers;
	}
}
