package lovage.teams.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lovage.domain.Player;
import lovage.domain.Team;
import lovage.teams.service.ITeamsService;

@Path("teams")
public class RestTeams {

	@EJB(beanName="TeamsServiceMock")
	private ITeamsService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Team> getTeams() {

		return service.getMinTeams();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Team getTeam(@PathParam("id") Long id) {

		Team team = service.getTeam(id);
		return team;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/add")
	public boolean addPlayer(@PathParam("id") Long id, Player player) {

		if (id == null) {
			return false;
		}

		if (player == null) {
			return false;
		}

		return service.addPlayer(id, player);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean create(Team team) {
		if (team == null) {
			return false;
		}

		if (!service.validate(team)) {
			return false;
		}

		return service.create(team);
	}
}