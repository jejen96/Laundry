package com.jejen.test.laundry.system.model.api;

public class OutletApi {
	
	private long id;
	private String nameOutlet;
	private String addressOutlet;
	private long phoneNumberOutlet;
	private String lat;
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
