package com.my.corp.demo.weather.weatherapp.cache;

/**maintain key for city and country cache
 * @author Akhan
 *
 */
public class CityCacheIdentity {

	private String city;
	private String countryCode;
	public CityCacheIdentity(String city, String countryCode) {
		super();
		this.city = city;
		this.countryCode = countryCode;
	}
	public String getCity() {
		return city;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
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
		CityCacheIdentity other = (CityCacheIdentity) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		return true;
	}
	
	
}
