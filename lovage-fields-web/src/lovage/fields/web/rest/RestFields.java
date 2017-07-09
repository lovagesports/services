package lovage.fields.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lovage.domain.Field;
import lovage.fields.service.IFieldsService;

@Path("fields")
public class RestFields {

	@EJB(beanName = "FieldsServiceMock")
	private IFieldsService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Field> getFields() {

		return service.getMinFields();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Field getFields(@PathParam("id") Long id) {
		Field field = service.getField(id);
		return field;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public boolean create(Field field) {
		if (field == null) {
			return false;
		}

		if (!service.validate(field)) {
			return false;
		}

		return service.create(field);
	}
}