package lovage.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Team {

	public Long id;
	public String name;
	public int capacity;
	public int joined;
	public List<Player> players = new ArrayList<Player>();
	public String location;
	public String start;
	public double duration;

	public Team() {
	}

	public Team(Long id, String name, int capacity, String location, String start, double duration) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.location = location;
		this.start = start;
		this.duration = duration;
		this.players = new ArrayList<Player>();
		this.joined = players.size();
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", capacity=" + capacity + ", joined=" + joined + ", players="
				+ players + ", location=" + location + ", start=" + start + ", duration=" + duration + "]";
	}
}
