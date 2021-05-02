package com.my.corp.demo.weather.weatherapp.dto;

import java.util.List;

/**
 * Simple POJO which map data with Third API response
 * 
 * @author Akhan
 *
 */
public class WeatherResponseDTO {
	private CoordDto coord;
	private List<WeatherDto> weather;
	private String base;
	private MainDto main;
	private String visibility;
	private WindDto wind;
	private String date;
	private CountryDto sys;
	private String name; // map to name field of response
	private boolean isFailed;
	private String responseStatus;
	private String errorMessage;

	public CoordDto getCoord() {
		return coord;
	}

	public void setCoord(CoordDto coord) {
		this.coord = coord;
	}

	public List<WeatherDto> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherDto> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public MainDto getMain() {
		return main;
	}

	public void setMain(MainDto main) {
		this.main = main;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public WindDto getWind() {
		return wind;
	}

	public void setWind(WindDto wind) {
		this.wind = wind;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public CountryDto getSys() {
		return sys;
	}

	public void setSys(CountryDto sys) {
		this.sys = sys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFailed() {
		return isFailed;
	}

	public void setFailed(boolean isFailed) {
		this.isFailed = isFailed;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
