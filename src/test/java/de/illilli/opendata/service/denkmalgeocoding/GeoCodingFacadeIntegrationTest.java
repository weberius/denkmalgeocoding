package de.illilli.opendata.service.denkmalgeocoding;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Diese Klasse testet den die GeoCodingFacade. Er setzt allerdings einen
 * laufenden GeoCoding Service voraus.
 */
public class GeoCodingFacadeIntegrationTest {

	public static final String encoding = "UTF-8";

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * The needed values for this test will be set via GeoCodingFacade -
	 * Constructor.
	 */

	@Test
	public void testGetJson() {
		Facade facade = new GeoCodingFacade(0.0, 0.0);
		String expected = "{\"osmId\":0,\"lon\":0.0,\"lat\":0.0,\"display_name\":\"for testing purpose\"}";
		String actual = facade.getJson();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetUnterKrahnenBaeumen() throws JsonParseException,
			JsonMappingException, IOException {

		String country = "de";
		String postcode = "50668";
		String city = "Köln";
		String street = "Unter Krahnenbäumen";
		String housenumber = "61-73";

		Facade facade = new GeoCodingFacade(country, postcode, city, street,
				housenumber);
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/testGetUnterKrahnenBaumenExpected.json");
		String expected = IOUtils.toString(inputStream, encoding);
		String actual = facade.getJson();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetBachstrasse() throws JsonParseException,
			JsonMappingException, IOException {

		String country = "de";
		String postcode = "51063";
		String city = "Köln";
		String street = "Bachstrasse";
		String housenumber = "11-13";

		Facade facade = new GeoCodingFacade(country, postcode, city, street,
				housenumber);
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/testGetBachstrasse11.json");
		String expected = IOUtils.toString(inputStream, encoding);
		String actual = facade.getJson();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetNiederwallBielefeld() throws JsonParseException,
			JsonMappingException, IOException {

		String country = "de";
		String postcode = "33602";
		String city = "Bielefeld";
		String street = "Niederwall";
		String housenumber = "23";

		Facade facade = new GeoCodingFacade(country, postcode, city, street,
				housenumber);
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/testGetBielefeldNiederwall.json");
		String expected = IOUtils.toString(inputStream, encoding);
		String actual = facade.getJson();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}

}
