package lovage.security.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.lang.StringUtils;

import lovage.domain.User;
import lovage.security.users.IUsersService;

@Stateless
public class SecurityService implements ISecurityService {

	@EJB
	private IUsersService service;

	@Override
	public String login(String username, String password) {

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return null;
		}

		User loggedIn = service.getUser(username, password);
		if (loggedIn == null) {
			return null;
		}

		return generateToken(loggedIn);
	}

	@Override
	public Boolean validateLogin(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	private String generateToken(User user) {
		return String.format("%s|%s", user.id.toString(), user.email);
	}
}
