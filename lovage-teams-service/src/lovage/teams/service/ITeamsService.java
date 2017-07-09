package lovage.teams.service;

import java.util.List;

import lovage.domain.Player;
import lovage.domain.Team;

public interface ITeamsService {

	List<Team> getMinTeams();
	Team getTeam(Long id);
	boolean addPlayer(Long id, Player player);
	boolean create(Team team);
	boolean validate(Team team);
}
