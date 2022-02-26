package com.jejen.test.laundry.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price_list")
public class PriceList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, columnDefinition = "serial")
	private long idPriceList;
	
	@Column(name = "name")
	private String namePriceList;
	
	@Column(name = "price")
	private long priceList;

	public long getIdPriceList() {
		return idPriceList;
	}

	public void setIdPriceList(long idPriceList) {
		this.idPriceList = idPriceList;
	}

	public long getPriceList() {
		return priceList;
	}

	public void setPriceList(long priceList) {
		this.priceList = priceList;
	}

	public String getNamePriceList() {
		return namePriceList;
	}

	public void setNamePriceList(String namePriceList) {
		this.namePriceList = namePriceList;
	}
	
	

	

}
