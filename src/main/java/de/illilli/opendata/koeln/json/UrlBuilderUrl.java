package de.illilli.opendata.koeln.json;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class UrlBuilderUrl extends UrlBuilder {

	private static final Logger logger = Logger.getLogger(UrlBuilderUrl.class);

	// String nominatimUrl = "http://nominatim.openstreetmap.org/search";
	String nominatimUrl = "http://ubuntu1404nominatim/nominatim/search.php";

	// String nominatimUrl =
	// "http://open.mapquestapi.com/nominatim/v1/search.php";

	public UrlBuilderUrl(String postcode, String city, String street,
			String housenumber) throws UnsupportedEncodingException {
		url = new StringBuilder(nominatimUrl);
		url.append(format);
		url.append(adressdetails);
		url.append(acceptLanguage);
		url.append(query);
		url.append(postcode);
		url.append(spaceCharakter);
		url.append(URLEncoder.encode(city, charSet));
		url.append(spaceCharakter);
		url.append(URLEncoder.encode(street, charSet));
		if (!"o.Nr.".equals(housenumber)) {
			url.append(spaceCharakter);
			url.append(URLEncoder.encode(housenumber, charSet));
		}
		logger.debug(url.toString());
	}

}
