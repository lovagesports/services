package lovage.security.service;

public interface ISecurityService {

	String login(String username, String password);

	Boolean validateLogin(String token);
}
