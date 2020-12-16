package com.matt.WeatherApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.matt.WeatherApp.Model.Response;
import com.matt.WeatherApp.Model.ZipCode;
import com.matt.WeatherApp.Repository.ZipCodeRepository;

@Service
public class WeatherService {

	
	
	@Value("${api_key}")
	private String apiKey;
	
	private Response response;

	public Response getForecast(String zipCode) {
		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid="
				+ apiKey;
		RestTemplate restTemplate = new RestTemplate();
		try {
			response = restTemplate.getForObject(url, Response.class);
			ZipCode zip = new ZipCode();
			zip.setZipCode(zipCode);
			
			saveZip(zip);
		} catch (HttpClientErrorException ex) {
			response.setName("error");
		}
		return response;
	}
	
	public Void saveZip(ZipCode zipCode) {
		ZipCodeRepository.save(zipCode);
	}

		public List<ZipCode> getlastTen() {
		List<ZipCode> zipCodeList = ZipCodeRepository.findAllByOrderByCreatedAtDesc();
//		List<ZipCode> lastTenZip = new ArrayList<>();
//		zipLoop: for (ZipCode zip : zipCodeList) {
//			if (lastTenZip.size() < 10) {
//				lastTenZip.add(zip);
//			}else {
//				break zipLoop;
//			}
//		}
		if (zipCodeList.size() > 10) {
			return zipCodeList.subList(0, 10);
			
		} else {
			return zipCodeList;
		}
	}
	
		
	}
	