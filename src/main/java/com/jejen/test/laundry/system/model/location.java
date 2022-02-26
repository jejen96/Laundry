package com.jejen.test.laundry.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "location")
public class location {
	
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  private Long latitude;
	  private Long longitude;
	  private Long store;

	  protected void Position() {}

	  public void Position(long latitude, long longitude, long store) {
	    this.latitude = latitude;
	    this.longitude = longitude;
	    this.store = store;
	  }
	  
	  public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getLatitude() {
			return latitude;
		}

		public void setLatitude(Long latitude) {
			this.latitude = latitude;
		}

		public Long getLongitude() {
			return longitude;
		}

		public void setLongitude(Long longitude) {
			this.longitude = longitude;
		}

		public Long getStore() {
			return store;
		}

		public void setStore(Long store) {
			this.store = store;
		}

}

	