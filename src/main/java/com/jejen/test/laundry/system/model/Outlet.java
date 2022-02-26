package com.jejen.test.laundry.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outlet")
public class Outlet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, columnDefinition = "serial")
	private long id;
		
	@Column(name = "name")
	private String nameOutlet;
	
	@Column(name = "address")
	private String addressOutlet;
	
	@Column(name = "phone_number")
	private long phoneNumberOutlet;
	
	@Column(name = "latitude")
	private String lat;
	
	@Column(name = "longitude")
	private String lng;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameOutlet() {
		return nameOutlet;
	}

	public void setNameOutlet(String nameOutlet) {
		this.nameOutlet = nameOutlet;
	}

	public String getAddressOutlet() {
		return addressOutlet;
	}

	public void setAddressOutlet(String addressOutlet) {
		this.addressOutlet = addressOutlet;
	}

	public long getPhoneNumberOutlet() {
		return phoneNumberOutlet;
	}

	public void setPhoneNumberOutlet(long phoneNumberOutlet) {
		this.phoneNumberOutlet = phoneNumberOutlet;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

}
