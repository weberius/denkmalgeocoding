package de.illilli.opendata.service.denkmalgeocoding;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.koeln.json.AskForGeoCodingNominatim;
import de.illilli.opendata.service.denkmalgeocoding.json.NominatimResult;

public class GeoCodingFacade implements Facade {

	private static final Logger logger = Logger
			.getLogger(GeoCodingFacade.class);

	private final static String QUOTES = "\"";
	private final static String COLON = ":";
	private final static String COMMA = ",";
	private final static String CULRY_BRACE_OPEN = "{";
	private final static String CULRY_BRACE_CLOSE = "}";

	private StringBuilder json = new StringBuilder("{}");
	private NominatimResult result = new NominatimResult();

	/**
	 * empty construktor; for testing reasons
	 */
	GeoCodingFacade(double lat, double lon) {
		result.lat = lat;
		result.lon = lon;
		result.osmId = 0l;
		result.displayName = "for testing purpose";
	}

	public GeoCodingFacade(InputStream inputStream) throws JsonParseException,
			JsonMappingException, IOException {
		AskForGeoCodingNominatim askFor = new AskForGeoCodingNominatim(
				inputStream);
		NominatimResult[] results = askFor.getNominatimResult();
		result = results[0];
	}

	public GeoCodingFacade(String country, String postcode, String city,
			String street, String housenumber) throws JsonParseException,
			JsonMappingException, IOException {
		AskForGeoCodingNominatim askFor = new AskForGeoCodingNominatim(country,
				postcode, city, street, housenumber);
		NominatimResult[] results = askFor.getNominatimResult();
		if (results.length > 0) {
			logger.debug(results[0]);
			result = results[0];
		}
	}

	public String getJson() {
		json = new StringBuilder(CULRY_BRACE_OPEN);
		json.append(QUOTES);
		json.append("osmId");
		json.append(QUOTES);
		json.append(COLON);
		json.append(result.osmId);
		json.append(COMMA);
		json.append(QUOTES);
		json.append("lon");
		json.append(QUOTES);
		json.append(COLON);
		json.append(result.lon);
		json.append(COMMA);
		json.append(QUOTES);
		json.append("lat");
		json.append(QUOTES);
		json.append(COLON);
		json.append(result.lat);
		json.append(COMMA);
		json.append(QUOTES);
		json.append("display_name");
		json.append(QUOTES);
		json.append(COLON);
		json.append(QUOTES);
		json.append(result.displayName);
		json.append(QUOTES);
		json.append(CULRY_BRACE_CLOSE);
		return json.toString();
	}
}
