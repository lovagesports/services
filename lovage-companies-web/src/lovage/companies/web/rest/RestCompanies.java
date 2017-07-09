package lovage.companies.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lovage.companies.service.ICompaniesService;
import lovage.domain.Company;
import lovage.domain.Field;

@Path("companies")
public class RestCompanies {

	@EJB(beanName = "CompaniesServiceMock")
	private ICompaniesService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Company> getCompanies() {

		return service.getMinCompanies();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Company getCompanies(@PathParam("id") Long id) {
		Company company = service.getCompany(id);
		return company;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/add")
	public boolean addField(@PathParam("id") Long id, Field field) {

		if (id == null) {
			return false;
		}

		if (field == null) {
			return false;
		}

		return service.addField(id, field);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean create(Company company) {
		if (company == null) {
			return false;
		}

		if (!service.validate(company)) {
			return false;
		}

		return service.create(company);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Company login(Company company) {
		if (company == null) {
			return null;
		}

		Company existing = service.login(company);
		return existing;
	}
}