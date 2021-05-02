package com.my.corp.demo.weather.weatherapp.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.my.corp.demo.weather.weatherapp.dto.WeatherResponseDTO;

/**Cache to hold data for city/country and polar weather information
 * @author Akhan
 *
 */
@Component
public class WeatherCache {

	private Map<CityCacheIdentity, WeatherResponseDTO> cityCacheMap = new HashMap<>();
	private Map<PolarCacheIdentity, WeatherResponseDTO> polarCacheMap = new HashMap<>();

	public WeatherResponseDTO getWeatherByCity(CityCacheIdentity key) {

		if (CollectionUtils.isEmpty(cityCacheMap)) {
			return null;
		} else {
			return cityCacheMap.get(key);
		}
	}

	public void pushCityCache(CityCacheIdentity key, WeatherResponseDTO data) {
		cityCacheMap.putIfAbsent(key, data);
	}

	public WeatherResponseDTO getWeatherByPolar(PolarCacheIdentity key) {

		if (CollectionUtils.isEmpty(polarCacheMap)) {
			return null;
		} else {
			return polarCacheMap.get(key);
		}
	}

	public void pushPolarCache(PolarCacheIdentity key, WeatherResponseDTO data) {
		polarCacheMap.putIfAbsent(key, data);
	}
	
	public void clearCache() {
		cityCacheMap.clear();
		polarCacheMap.clear();
	}
}
