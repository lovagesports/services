package lovage.fields.web.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class RestApplication extends Application {

	public RestApplication() {
		System.out.println("Fields rest app started");
	}
}
