package lovage.domain;

import java.util.ArrayList;
import java.util.List;

public class Company extends User {

	public String name;
	public List<Field> fields = new ArrayList<Field>();

	public Company() {
		super(UserType.Company);
	}

	public Company(Long id, String name, String email, String password) {
		super(UserType.Player, id, email, password);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", fields=" + fields + ", id=" + id + ", email=" + email + ", password="
				+ password + ", type=" + type + "]";
	}
}
