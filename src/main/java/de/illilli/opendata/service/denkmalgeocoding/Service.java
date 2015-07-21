package de.illilli.opendata.service.denkmalgeocoding;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("/service")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private StringBuilder json = new StringBuilder("{}");

	/**
	 * <p>
	 * Beispiel:
	 * </p>
	 * <p>
	 * <a
	 * href="http://localhost:8080/denkmalgeocoding/service">http://localhost:
	 * 8080/denkmalgeocoding/service</a>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/")
	public String getDefaultValue() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		Facade facade = new GeoCodingFacade(0.0, 0.0);
		json = new StringBuilder(facade.getJson());
		logger.debug(json.toString());
		return json.toString();
	}

	/**
	 * <p>
	 * Beispiel: <a href=
	 * "http://localhost:8080/denkmalgeocoding/service/de/50668/K%C3%B6ln/Unter%20Krahnenb%C3%A4umen/61-73"
	 * >Köln, Unter Krahnebäumen 61-73</a>
	 * </p>
	 * 
	 * @param country
	 * @param postcode
	 * @param city
	 * @param street
	 * @param housenumber
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{postcode}/{city}/{street}/{housenumber}")
	public String getlatlon(@PathParam("postcode") String postcode,
			@PathParam("city") String city, @PathParam("street") String street,
			@PathParam("housenumber") String housenumber)
			throws JsonParseException, JsonMappingException, IOException,
			URISyntaxException {
		response.setCharacterEncoding("UTF-8");
		Facade facade = new GeoCodingFacade(postcode, city, street, housenumber);
		json = new StringBuilder(facade.getJson());
		logger.debug(json.toString());
		return json.toString();
	}

}
