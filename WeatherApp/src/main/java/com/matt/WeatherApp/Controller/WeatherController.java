package com.matt.WeatherApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.matt.WeatherApp.Model.Request;
import com.matt.WeatherApp.Model.Response;
import com.matt.WeatherApp.Model.ZipCode;
import com.matt.WeatherApp.Repository.ZipCodeRepository;
import com.matt.WeatherApp.Service.WeatherService;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("request", new Request());
		model.addAttribute("zipcodes", weatherService.getlastTen());
		return "index";
	}

	@PostMapping
	public String postIndex(Request request, Model model) {
		Response data = weatherService.getForecast(request.getZipcode());
		model.addAttribute("data", data);
		model.addAttribute("zipcodes", weatherService.getlastTen());
		return "index";
	}

	
}
