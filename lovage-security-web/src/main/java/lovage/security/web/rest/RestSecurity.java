package lovage.security.web.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lovage.security.domain.Login;
import lovage.security.service.ISecurityService;

@Path("security")
public class RestSecurity {

	@EJB
	private ISecurityService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("login")
	public String login(Login login) {

		return service.login(login.username, login.password);
	}
}