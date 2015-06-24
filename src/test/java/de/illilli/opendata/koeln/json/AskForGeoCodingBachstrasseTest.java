package de.illilli.opendata.koeln.json;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.denkmalgeocoding.json.NominatimResult;

public class AskForGeoCodingBachstrasseTest {

	private NominatimResult[] results;

	@Before
	public void setUp() throws Exception {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nominatim_bachstrasse.json");
		AskForGeoCodingNominatim askfor = new AskForGeoCodingNominatim(
				inputStream);
		results = askfor.getNominatimResult();
	}

	@Test
	public void testBachstrasseLength() throws Exception {
		int expected = 10;
		int actual = results.length;
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Dieser Test prüft auf das Auslesen des Wertes lat.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBachstrasselat() throws Exception {
		Double expected = 50.9623998;
		Double actual = results[0].lat;
		Assert.assertEquals(expected, actual);
	}

}
