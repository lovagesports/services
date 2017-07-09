package lovage.players.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import lovage.domain.Player;

public abstract class PlayersServiceBase implements IPlayersService {

	public abstract List<Player> getMinPlayers();

	public abstract Player getPlayer(Long id);

	public abstract Player getPlayer(String email);

	public abstract boolean create(Player player);

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

	public Player login(Player player) {

		Player found = getPlayer(player.email);
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
}
