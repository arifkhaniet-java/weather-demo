package com.my.corp.demo.weather.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainDto {
	private String temp;
	@JsonProperty("feels_like")
	private String feels_like;
	@JsonProperty("temp_min")
	private String temp_min;
	@JsonProperty("temp_max")
	private String temp_max;
	private String pressure;
	private String humidity;
	@JsonProperty("sea_level")
	private String sea_level;
	@JsonProperty("grnd_level")
	private String grnd_level;
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(String feels_like) {
		this.feels_like = feels_like;
	}
	public String getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}
	public String getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getSea_level() {
		return sea_level;
	}
	public void setSea_level(String sea_level) {
		this.sea_level = sea_level;
	}
	public String getGrnd_level() {
		return grnd_level;
	}
	public void setGrnd_level(String grnd_level) {
		this.grnd_level = grnd_level;
	}
	
	
}
