package lovage.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player extends User {

	public String name;
	public String birth;

	public Player() {
		super(UserType.Player);
	}

	public Player(Long id, String name, String email, String password, String birth) {
		super(UserType.Player, id, email, password);
		this.name = name;
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", birth=" + birth + ", id=" + id + ", email=" + email + ", password="
				+ password + ", type=" + type + "]";
	}
}
