package com.my.corp.demo.weather.weatherapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.my.corp.demo.weather.weatherapp.cache.CityCacheIdentity;
import com.my.corp.demo.weather.weatherapp.cache.PolarCacheIdentity;
import com.my.corp.demo.weather.weatherapp.dto.ResponseStatus;
import com.my.corp.demo.weather.weatherapp.dto.WeatherResponseDTO;
import com.my.corp.demo.weather.weatherapp.exception.ApiException;

/**
 * Utility to call Third party API to get live data
 * 
 * @author Akhan
 *
 */
@Component
public class WeatherUtil {

	private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
	private static final String CITY_QUERY_PARAM = "q=";
	private static final String LAT = "lat=";
	private static final String LON = "&lon=";
	private static final String APP_KEY = "&APPID=ffa6f13ea40a22452bba3be726315d3f";

	public WeatherResponseDTO getCityAndCountryWeather(CityCacheIdentity identity) {
		String urlString = BASE_URL + CITY_QUERY_PARAM + identity.getCity() + "," + identity.getCountryCode() + APP_KEY;
		return getLiveDataFromThirdPartyApi(urlString);
	}

	public WeatherResponseDTO getPolarWeather(PolarCacheIdentity identity) {
		String urlString = BASE_URL + LAT + identity.getLat() + LON + identity.getLon() + APP_KEY;
		return getLiveDataFromThirdPartyApi(urlString);
	}

	private WeatherResponseDTO getLiveDataFromThirdPartyApi(String urlString) {
		WeatherResponseDTO responseDto = new WeatherResponseDTO();
		String response = "";

		try {
			response = getResponse(urlString);
			responseDto = mapToResponse(response);
			responseDto.setResponseStatus(ResponseStatus.SUCCESS.name());
		} catch (Exception e) {
			responseDto.setResponseStatus(ResponseStatus.FAILED.name());
			responseDto.setFailed(true);
			responseDto.setErrorMessage(e.getMessage());
		}
		return responseDto;
	}

	private WeatherResponseDTO mapToResponse(String response) {
		Gson gson = new GsonBuilder().create();
		WeatherResponseDTO responseDto = gson.fromJson(response, WeatherResponseDTO.class);
		responseDto.setResponseStatus(ResponseStatus.SUCCESS.name());
		return responseDto;
	}

	private String getResponse(String urlString) throws ApiException {
		try {

			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			rd.close();

			return result.toString();
		} catch (IOException e) {
			throw new ApiException(e.getMessage());
		}

	}
}
