package com.my.corp.demo.weather.weatherapp.dto;

public enum ResponseStatus {

	SUCCESS("SUCCESS"),
	FAILED("FAILED");
	
	private String status;

	private ResponseStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
