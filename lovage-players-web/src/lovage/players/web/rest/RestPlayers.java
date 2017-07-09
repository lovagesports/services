package lovage.players.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lovage.domain.Player;
import lovage.players.service.IPlayersService;
import lovage.players.service.PlayersServiceMock;

@Path("players")
public class RestPlayers {

	private final IPlayersService service = new PlayersServiceMock();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Player> getPlayers() {

		return service.getMinPlayers();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Player getPlayers(@PathParam("id") Long id) {
		Player player = service.getPlayer(id);
		return player;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean create(Player player) {
		if (player == null) {
			return false;
		}

		if (!service.validate(player)) {
			return false;
		}

		return service.create(player);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Player login(Player player) {
		if (player == null) {
			return null;
		}

		Player existing = service.login(player);
		return existing;
	}
}
