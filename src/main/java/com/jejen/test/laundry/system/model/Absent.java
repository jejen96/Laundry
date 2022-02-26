package com.jejen.test.laundry.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "absen")
public class Absent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, columnDefinition = "serial")
	private long id;
	
	@Column(name = "id _employee")
	private String idEmployee;
	
	@Column(name = "name_employee")
	private String nameEmployee;
	
	@Column(name = "date_work")
	private Date dateWork;
	
	@Column(name = "hour_in")
	private Date hourIn;
	
	@Column(name = "hour_out")
	private Date hourOut;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public Date getDateWork() {
		return dateWork;
	}

	public void setDateWork(Date dateWork) {
		this.dateWork = dateWork;
	}

	public Date getHourIn() {
		return hourIn;
	}

	public void setHourIn(Date hourIn) {
		this.hourIn = hourIn;
	}

	public Date getHourOut() {
		return hourOut;
	}

	public void setHourOut(Date hourOut) {
		this.hourOut = hourOut;
	}
	
	
	
}
