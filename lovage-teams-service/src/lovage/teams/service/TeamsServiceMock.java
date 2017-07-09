package lovage.teams.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lovage.domain.Player;
import lovage.domain.Team;

public class TeamsServiceMock implements ITeamsService {

	private static final Map<Long, Team> teams = initMockTeams();

	@Override
	public Team getTeam(Long id) {
		Team team = teams.get(id);
		return team;
	}

	@Override
	public List<Team> getMinTeams() {
		List<Team> result = new ArrayList<Team>();
		for (Entry<Long, Team> entry : teams.entrySet()) {

			Team copy = new Team();
			copy.capacity = entry.getValue().capacity;
			copy.id = entry.getValue().id;
			copy.joined = entry.getValue().joined;
			copy.name = entry.getValue().name;
			copy.location = entry.getValue().location;
			copy.start = entry.getValue().start;
			copy.duration = entry.getValue().duration;
			result.add(copy);
		}

		return result;
	}

	@Override
	public boolean addPlayer(Long id, Player player) {

		Team team = teams.get(id);
		if (team == null) {
			return false;
		}

		team.joined++;
		return team.players.add(player);
	}

	@Override
	public boolean create(Team team) {
		if (team == null) {
			return false;
		}

		teams.put(team.id, team);

		return true;
	}

	@Override
	public boolean validate(Team team) {

		if (team.joined != team.players.size()) {

			System.out.println(String.format("Team %d: Adjusting 'joined' from: %d to team size: %d", team.id,
					team.joined, team.players.size()));
			team.joined = team.players.size();
		}

		return true;
	}

	private static Map<Long, Team> initMockTeams() {
		Map<Long, Team> mockTeams = new HashMap<Long, Team>();

		Team team1 = new Team(1L, "team 1", 4, "Baza transilvania teren 1", "Today, from 17:00", 1);
		mockTeams.put(team1.id, team1);

		List<Player> players2 = new ArrayList<Player>();
		Player player1 = new Player();
		player1.name = "Player 1";
		player1.id = 33L;
		players2.add(player1);

		Team team2 = new Team(2L, "team 2", 12, "Liceul sportiv teren 2", "Tomorrow, from 18:30", 1.5);
		team2.players = players2;
		mockTeams.put(team2.id, team2);

		Team team3 = new Team(3L, "team 3", 4, "Baza transilvania teren 2", "2017-06-11, from 22:00", 1);
		mockTeams.put(team3.id, team3);

		return mockTeams;
	}
}
