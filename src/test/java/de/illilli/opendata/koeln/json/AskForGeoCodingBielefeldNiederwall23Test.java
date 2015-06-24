package de.illilli.opendata.koeln.json;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.denkmalgeocoding.json.NominatimResult;

public class AskForGeoCodingBielefeldNiederwall23Test {

	private NominatimResult[] results;

	@Before
	public void setUp() throws Exception {
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/nominatim_bielefeld_niederwall_23.json");
		AskForGeoCodingNominatim askfor = new AskForGeoCodingNominatim(
				inputStream);
		results = askfor.getNominatimResult();
	}

	@Test
	public void testlength() throws Exception {
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
	public void testlat() throws Exception {
		Double expected = 52.0215339;
		Double actual = results[0].lat;
		Assert.assertEquals(expected, actual);
	}

}
