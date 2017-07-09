package lovage.teams.service;

import java.util.List;

import javax.ejb.Stateless;

import lovage.domain.Player;
import lovage.domain.Team;

@Stateless
public class TeamsService implements ITeamsService {

	@Override
	public List<Team> getMinTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getTeam(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPlayer(Long id, Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(Team team) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validate(Team team) {
		// TODO Auto-generated method stub
		return false;
	}
}
