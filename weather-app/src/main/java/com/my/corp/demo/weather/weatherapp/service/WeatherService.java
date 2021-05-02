package com.my.corp.demo.weather.weatherapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.my.corp.demo.weather.weatherapp.cache.CityCacheIdentity;
import com.my.corp.demo.weather.weatherapp.cache.PolarCacheIdentity;
import com.my.corp.demo.weather.weatherapp.cache.WeatherCache;
import com.my.corp.demo.weather.weatherapp.dto.WeatherResponseDTO;
import com.my.corp.demo.weather.weatherapp.util.WeatherUtil;

@Service
public class WeatherService {

	@Autowired
	WeatherCache weatherCache;
	@Autowired
	WeatherUtil weatherUtil;

	/**
	 * Check city/country weather data from cache and return otherwise call third party API
	 * to get the data and update the cache
	 * 
	 * @param city
	 * @param countryCode
	 * @return
	 */
	public WeatherResponseDTO getWeatherByCity(String city, String countryCode) {
		CityCacheIdentity cityCacheIdentity = new CityCacheIdentity(city, countryCode);
		WeatherResponseDTO weatherResponseDTO = weatherCache.getWeatherByCity(cityCacheIdentity);
		if (ObjectUtils.isEmpty(weatherResponseDTO)) {
			weatherResponseDTO = getWeatherByCityLiveData(cityCacheIdentity);
		}
		return weatherResponseDTO;

	}

	private WeatherResponseDTO getWeatherByCityLiveData(CityCacheIdentity cityCacheIdentity) {
		WeatherResponseDTO dto = weatherUtil.getCityAndCountryWeather(cityCacheIdentity);

		// Push data in to cache : City and Country
		weatherCache.pushCityCache(cityCacheIdentity, dto);
		return dto;
	}

	/**
	 * Check polar weather data from cache and return otherwise call third party API
	 * to get the data and update the cache
	 * 
	 * @param lat
	 * @param lon
	 * @return
	 */
	public WeatherResponseDTO getWeatherByPolar(String lat, String lon) {
		PolarCacheIdentity polarCacheIdentity = new PolarCacheIdentity(lat, lon);
		WeatherResponseDTO weatherResponseDTO = weatherCache.getWeatherByPolar(polarCacheIdentity);
		if (ObjectUtils.isEmpty(weatherResponseDTO)) {
			weatherResponseDTO = getWeatherByPolarLiveData(polarCacheIdentity);
		}
		return weatherResponseDTO;

	}

	private WeatherResponseDTO getWeatherByPolarLiveData(PolarCacheIdentity polarCacheIdentity) {
		WeatherResponseDTO dto = weatherUtil.getPolarWeather(polarCacheIdentity);

		// Push data in to cache : Polar
		weatherCache.pushPolarCache(polarCacheIdentity, dto);
		return dto;
	}

}
