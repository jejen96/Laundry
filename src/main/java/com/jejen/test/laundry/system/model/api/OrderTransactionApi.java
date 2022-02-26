package com.jejen.test.laundry.system.model.api;

import java.util.Date;

public class OrderTransactionApi {
	
	private long idOrderTransaction;
	private String nameOrder;
	private long phoneNumberOrder;
	private String addressOrder;
	private Date timePickup;
	private long totalAmountOrder;
	private long idOutlet;
	private long idRoleTransaction;
	
	public long getIdOrderTransaction() {
		return idOrderTransaction;
	}
	public void setIdOrderTransaction(long idOrderTransaction) {
		this.idOrderTransaction = idOrderTransaction;
	}
	public String getNameOrder() {
		return nameOrder;
	}
	public void setNameOrder(String nameOrder) {
		this.nameOrder = nameOrder;
	}
	public long getPhoneNumberOrder() {
		return phoneNumberOrder;
	}
	public void setPhoneNumberOrder(long phoneNumberOrder) {
		this.phoneNumberOrder = phoneNumberOrder;
	}
	public String getAddressOrder() {
		return addressOrder;
	}
	public void setAddressOrder(String addressOrder) {
		this.addressOrder = addressOrder;
	}
	public Date getTimePickup() {
		return timePickup;
	}
	public void setTimePickup(Date timePickup) {
		this.timePickup = timePickup;
	}
	public long getTotalAmountOrder() {
		return totalAmountOrder;
	}
	public void setTotalAmountOrder(long totalAmountOrder) {
		this.totalAmountOrder = totalAmountOrder;
	}
	public long getIdOutlet() {
		return idOutlet;
	}
	public void setIdOutlet(long idOutlet) {
		this.idOutlet = idOutlet;
	}
	public long getIdRoleTransaction() {
		return idRoleTransaction;
	}
	public void setIdRoleTransaction(long idRoleTransaction) {
		this.idRoleTransaction = idRoleTransaction;
	}
	
	
	
}
