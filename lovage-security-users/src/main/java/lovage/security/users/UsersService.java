package lovage.security.users;

import javax.ejb.Stateless;

import lovage.domain.User;

@Stateless
public class UsersService implements IUsersService {

	@Override
	public User getUser(String username, String password) {
		return null;
	}

}
