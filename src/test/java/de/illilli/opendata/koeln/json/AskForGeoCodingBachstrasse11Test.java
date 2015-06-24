package de.illilli.opendata.koeln.json;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.denkmalgeocoding.json.NominatimResult;

public class AskForGeoCodingBachstrasse11Test {

	private NominatimResult[] results;

	@Before
	public void setUp() throws Exception {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nominatim_bachstrasse_11.json");
		AskForGeoCodingNominatim askfor = new AskForGeoCodingNominatim(
				inputStream);
		results = askfor.getNominatimResult();
	}

	@Test
	public void testBachstrasse11length() throws Exception {
		int expected = 1;
		int actual = results.length;
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Dieser Test prüft auf das Auslesen des Wertes lat.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBachstrasse11lat() throws Exception {
		Double expected = 50.9625587;
		Double actual = results[0].lat;
		Assert.assertEquals(expected, actual);
	}

}
