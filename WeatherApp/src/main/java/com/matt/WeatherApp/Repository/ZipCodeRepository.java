package com.matt.WeatherApp.Repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.matt.WeatherApp.Model.ZipCode;

public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
	public List<ZipCode> findAllByOrderByCreatedAtDesc();
	public List<ZipCode> findAll();

}
