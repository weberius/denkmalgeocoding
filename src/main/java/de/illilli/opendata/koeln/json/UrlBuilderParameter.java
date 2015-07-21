package de.illilli.opendata.koeln.json;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Beispiel: <a href=
 * "http://ubuntu1404nominatim/nominatim/search.php?format=json&addressdetails=1&q=&postalcode=50668&city=K%C3%B6ln&street=Unter+Krahnenb%C3%A4umen+61-73"
 * >61-73, Unter Krahnenbäumen, Kuniberts-Viertel, Altstadt-Nord, Innenstadt,
 * Köln, Regierungsbezirk Köln, Nordrhein-Westfalen, 50668, Germany</a>
 * 
 */
public class UrlBuilderParameter extends UrlBuilder {

	// String nominatimUrl = "http://nominatim.openstreetmap.org/search";
	String nominatimUrl = "http://ubuntu1404nominatim/nominatim/search.php";

	// String nominatimUrl =
	// "http://open.mapquestapi.com/nominatim/v1/search.php";

	public UrlBuilderParameter(String postcode, String city, String street,
			String housenumber) throws UnsupportedEncodingException {
		url = new StringBuilder(nominatimUrl);
		url.append(format);
		url.append(adressdetails);
		url.append(query);
		url.append("&postalcode=");
		url.append(postcode.trim());
		url.append("&city=");
		url.append(URLEncoder.encode(city.trim(), charSet));
		url.append("&street=");
		url.append(URLEncoder.encode(street.trim(), charSet));
		if (!"o.Nr.".equals(housenumber)) {
			url.append(spaceCharakter);
			url.append(URLEncoder.encode(housenumber.trim(), charSet));
		}
	}

}
