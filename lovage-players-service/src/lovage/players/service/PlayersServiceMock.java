package lovage.players.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import lovage.domain.Player;
import lovage.utils.KeyUtils;

public class PlayersServiceMock implements IPlayersService {

	private static final Map<Long, Player> players = initMockPlayers();

	@Override
	public Player getPlayer(Long id) {
		Player player = players.get(id);
		return player;
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

	@Override
	public boolean validate(Player player) {

		if (StringUtils.isBlank(player.name)) {
			System.out.println(String.format("Player name is empty. Make sure the player name is filled."));
			return false;
		}

		if (StringUtils.isBlank(player.email)) {
			System.out.println(String.format("Player email is empty. Make sure the player email is filled."));
			return false;
		}

		if (StringUtils.isBlank(player.password)) {
			System.out.println(String.format("Player password is empty. Make sure the player password is filled."));
			return false;
		}

		if (player.birth == null) {
			System.out.println(String.format("Player birth date is empty. Make sure the player birth date is filled."));
			return false;
		}

		return true;
	}

	@Override
	public Player login(Player player) {

		Player found = findPlayer(player.email);
		if (found == null) {
			System.out.println(String.format("Login attempt for %s failed. Unknown e-mail.", player.email));
			return null;
		}

		if (!StringUtils.equals(found.password, player.password)) {
			System.out.println(String.format("Login attempt for %s failed. Password mismatch.", player.email));
			return null;
		}

		return found;
	}

	private Player findPlayer(String email) {

		Player found = players.values().stream().filter(item -> StringUtils.equals(email, item.email)).findFirst()
				.orElse(null);

		return found;
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
