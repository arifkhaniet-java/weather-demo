package com.my.corp.demo.weather.weatherapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.corp.demo.weather.weatherapp.dto.WeatherResponseDTO;
import com.my.corp.demo.weather.weatherapp.service.WeatherService;

/**Rest API to get city/country and polar weather information
 * @author Akhan
 *
 */
@RestController
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	@GetMapping("/weather-city")
	public WeatherResponseDTO getWeatherByCity(@RequestParam String city, @RequestParam String countryCode) {
	    return weatherService.getWeatherByCity(city,countryCode);
	}
	
	@GetMapping("/weather-polar")
	public WeatherResponseDTO getWeatherByPolar(@RequestParam String lat, @RequestParam String lon) {
	    return weatherService.getWeatherByPolar(lat, lon);
	}

}
