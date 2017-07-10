package lovage.security.users;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

import lovage.domain.Company;
import lovage.domain.Field;
import lovage.domain.FieldType;
import lovage.domain.Player;
import lovage.domain.User;
import lovage.domain.UserType;

@Stateless
public class UsersService implements IUsersService {

	private static final Map<Long, User> users = initMockUsers();

	@Override
	public User getUser(String username, String password) {

		for (User user : users.values()) {
			if (StringUtils.equals(user.email, username) && StringUtils.equals(user.password, password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public Map<Long, Player> getPlayers() {

		Map<Long, Player> players = new HashMap<Long, Player>();
		for (User user : users.values()) {
			if (user.type == UserType.Player && user instanceof Player) {
				players.put(user.id, (Player) user);
			}
		}
		return players;
	}

	@Override
	public Map<Long, Company> getCompanies() {
		Map<Long, Company> companies = new HashMap<Long, Company>();
		for (User user : users.values()) {
			if (user.type == UserType.Company && user instanceof Company) {
				companies.put(user.id, (Company) user);
			}
		}
		return companies;
	}

	private static Map<Long, User> initMockUsers() {
		Map<Long, User> mockUsers = new HashMap<Long, User>();

		try {
			Player player1 = new Player(100L, "Dorin Mateiu", "dorin.mateiu@lovage.ro", "test", "05/05/2985");
			mockUsers.put(player1.id, player1);
		} catch (Exception e) {
			System.out.println(e);
		}

		Player player2 = new Player(101L, "Cosmin Haiducu", "cosmin.haiducu@lovage.ro", "test", "22/12/1990");
		mockUsers.put(player2.id, player2);

		Company company1 = new Company(200L, "Baza Transilvania", "transilvania@primariacluj.ro", "test");
		Field field1 = new Field(1L, FieldType.Football, "Teren 1", 35, 20);
		field1.id = 20L;
		company1.fields.add(field1);
		mockUsers.put(company1.id, company1);

		Company company2 = new Company(201L, "Cora", "contact@terencora.ro", "test");
		mockUsers.put(company2.id, company2);

		return mockUsers;
	}
}
