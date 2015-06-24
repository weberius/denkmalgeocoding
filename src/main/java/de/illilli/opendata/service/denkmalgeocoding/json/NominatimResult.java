package de.illilli.opendata.service.denkmalgeocoding.json;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NominatimResult {

	@JsonProperty("place_id")
	public String placeId;
	@JsonProperty("licence")
	public String licence;
	@JsonProperty("osm_type")
	public String osm_type;
	@JsonProperty("osm_id")
	public long osmId;
	@JsonProperty("boundingbox")
	public Double[] boundingbox;
	@JsonProperty("lat")
	public Double lat;
	@JsonProperty("lon")
	public Double lon;
	@JsonProperty("display_name")
	public String displayName;
	@JsonProperty("class")
	public String resultClass;
	@JsonProperty("type")
	public String type;
	@JsonProperty("importance")
	public Double importance;
	@JsonProperty("address")
	public Address address;
	@JsonProperty("icon")
	public String icon;

	@Override
	public String toString() {
		return "Result [placeId=" + placeId + ", licence=" + licence
				+ ", osm_type=" + osm_type + ", osmId=" + osmId
				+ ", boundingbox=" + Arrays.toString(boundingbox) + ", lat="
				+ lat + ", lon=" + lon + ", displayName=" + displayName
				+ ", resultClass=" + resultClass + ", type=" + type
				+ ", importance=" + importance + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + Arrays.hashCode(boundingbox);
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result
				+ ((importance == null) ? 0 : importance.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((licence == null) ? 0 : licence.hashCode());
		result = prime * result + ((lon == null) ? 0 : lon.hashCode());
		result = prime * result + (int) (osmId ^ (osmId >>> 32));
		result = prime * result
				+ ((osm_type == null) ? 0 : osm_type.hashCode());
		result = prime * result + ((placeId == null) ? 0 : placeId.hashCode());
		result = prime * result
				+ ((resultClass == null) ? 0 : resultClass.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NominatimResult other = (NominatimResult) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (!Arrays.equals(boundingbox, other.boundingbox))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (importance == null) {
			if (other.importance != null)
				return false;
		} else if (!importance.equals(other.importance))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (licence == null) {
			if (other.licence != null)
				return false;
		} else if (!licence.equals(other.licence))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
			return false;
		if (osmId != other.osmId)
			return false;
		if (osm_type == null) {
			if (other.osm_type != null)
				return false;
		} else if (!osm_type.equals(other.osm_type))
			return false;
		if (placeId == null) {
			if (other.placeId != null)
				return false;
		} else if (!placeId.equals(other.placeId))
			return false;
		if (resultClass == null) {
			if (other.resultClass != null)
				return false;
		} else if (!resultClass.equals(other.resultClass))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
