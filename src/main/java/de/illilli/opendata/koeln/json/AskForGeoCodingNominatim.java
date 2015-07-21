package de.illilli.opendata.koeln.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.denkmalgeocoding.json.NominatimResult;

/**
 * Abfrage des Nominatim-Service
 * <p>
 * Beispiel: <a href=
 * "http://ubuntu1404nominatim/nominatim/?format=json&q=50823%20k%C3%B6ln%20parkg%C3%BCrtel%2024"
 * >http://ubuntu1404nominatim/nominatim/?format=json&q=50823%20k%C3%B6ln%20
 * parkg%C3%BCrtel%2024</a>
 * </p>
 *
 */
public class AskForGeoCodingNominatim {

	private static final Logger logger = Logger
			.getLogger(AskForGeoCodingNominatim.class);
	private NominatimResult[] nominatimResult;

	public AskForGeoCodingNominatim(String postcode, String city,
			String street, String housenumber) throws MalformedURLException,
			IOException {
		URL url = new UrlBuilderUrl(postcode, city, street, housenumber)
				.getUrl();

		InputStream inputStream = url.openStream();
		ObjectMapper mapper = new ObjectMapper();
		nominatimResult = mapper
				.readValue(inputStream, NominatimResult[].class);
		logger.debug(nominatimResult.toString());
		inputStream.close();
	}

	/**
	 * Mit diesem Konstruktur kann das parsen der json-Struktur getestet werden.
	 * Über
	 * 
	 * <pre>
	 * InputStream inputStream = this.getClass().getResourceAsStream(&quot;/&lt;file&gt;.json&quot;);
	 * </pre>
	 * 
	 * wird eine in den resources abgelegte Datei eingelesen. Sie entspricht in
	 * ihrer Struktur der Antwort eines Nominatim Servers.
	 * 
	 * @param inputStream
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public AskForGeoCodingNominatim(InputStream inputStream)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		nominatimResult = mapper
				.readValue(inputStream, NominatimResult[].class);
		logger.debug(nominatimResult.toString());

	}

	public NominatimResult[] getNominatimResult() {
		return nominatimResult;
	}

}
