package de.illilli.opendata.koeln.json;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class UrlBuilder {

	String format = "?format=json";
	String adressdetails = "&addressdetails=1";
	String query = "&q=";
	String charSet = "UTF-8";
	String spaceCharakter = "+";

	StringBuilder url;

	public URL getUrl() throws MalformedURLException {
		return new URL(url.toString());
	}

}
