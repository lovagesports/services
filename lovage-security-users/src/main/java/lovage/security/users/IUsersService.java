package lovage.security.users;

import lovage.domain.User;

public interface IUsersService {

	User getUser(String username, String password);
}
