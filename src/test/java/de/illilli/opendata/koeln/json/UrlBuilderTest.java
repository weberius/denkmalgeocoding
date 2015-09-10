package de.illilli.opendata.koeln.json;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UrlBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetUrl() throws UnsupportedEncodingException,
			MalformedURLException {

		String postcode = "50668";
		String city = "Köln";
		String street = "Unter Krahnenbäumen";
		String housenumber = "61-73";

		UrlBuilderUrl urlBuilder = new UrlBuilderUrl(postcode, city, street,
				housenumber);
		URL url = urlBuilder.getUrl();

		// String expected =
		// "http://nominatim.openstreetmap.org/search?format=json&addressdetails=1&q=de%2050668%20K%C3%B6ln%20Unter+Krahnenb%C3%A4umen%2061-73";
		String expected = "http://ubuntu1404nominatim/nominatim/search.php?format=json&addressdetails=1&accept-language=de-DE&q=50668+K%C3%B6ln+Unter+Krahnenb%C3%A4umen+61-73";
		String actual = url.toString();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}

}
