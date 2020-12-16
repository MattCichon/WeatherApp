package com.matt.WeatherApp.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class ZipCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String ZipCode;
	
	@CreationTimestamp
	private Date createdAt;
	
	public ZipCode(String zipcode, Date createdAt) {
		this.ZipCode = ZipCode;
		this.createdAt = createdAt;
	}
	
	public ZipCode() {
	}
	
	public Long getId() {
		return this.id;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

}
