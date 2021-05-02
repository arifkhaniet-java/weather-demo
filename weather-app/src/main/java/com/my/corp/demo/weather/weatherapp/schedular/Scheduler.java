package com.my.corp.demo.weather.weatherapp.schedular;

import org.springframework.stereotype.Component;

import com.my.corp.demo.weather.weatherapp.cache.WeatherCache;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * It executes in every 2 hours to clear weather cache
 * 
 * @author BOSS
 *
 */
@Component
public class Scheduler {
	@Autowired
	WeatherCache weatherCache;

	// @Scheduled(initialDelay = 1000, fixedRate = 10000)
	@Scheduled(fixedRate = 60 * 2 * 60 * 1000)
	public void clearWeatherCache() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("reset cache : Executes task in every 2 hrs:: " + strDate);

	}
}
