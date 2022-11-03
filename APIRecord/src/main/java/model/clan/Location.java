package model.clan;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	private int id;
	private String name;
	@JsonProperty(value="isCountry")
	private boolean isCountry;
	private String countryCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCountry() {
		return isCountry;
	}
	public void setCountry(boolean isCountry) {
		this.isCountry = isCountry;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


}
