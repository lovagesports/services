package lovage.security.users;

import java.util.Map;

import lovage.domain.Company;
import lovage.domain.Player;
import lovage.domain.User;

public interface IUsersService {

	User getUser(String username, String password);

	Map<Long, Player> getPlayers();

	Map<Long, Company> getCompanies();
}
