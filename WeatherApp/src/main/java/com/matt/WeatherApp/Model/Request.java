package com.matt.WeatherApp.Model;


public class Request {
	private String zipCode;
	
	public Request() {
		
	}
	
	public Request(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getZipcode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "Request [zipCode=" + zipCode + "]";
	}
	
}
