package com.my.corp.demo.weather.weatherapp.exception;

/**
 * Responsible to map custom exception
 * 
 * @author BOSS
 *
 */
public class ApiException extends Exception {

	public ApiException(String message) {
		super(message);
	}

}
