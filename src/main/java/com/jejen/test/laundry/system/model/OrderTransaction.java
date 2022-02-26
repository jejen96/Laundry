package com.jejen.test.laundry.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_transaction")
public class OrderTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, columnDefinition = "serial")
	private long id;
	
	@Column(name = "order_name")
	private String nameOrder;
	
	@Column(name = "phone_number")
	private long phoneNumberOrder;
	
	@Column(name = "address")
	private String addressOrder;
	
	@Column(name = "time_pickup")
	private Date timePickup;
	
	@Column(name = "total_amount_order")
	private long totalAmountOrder;
	
	@ManyToOne
	@JoinColumn(name = "id_outlet")
	private Outlet outlet;
	
	@ManyToOne
	@JoinColumn(name = "id_role_transaction")
	private RoleTransaction roleTransaction;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public RoleTransaction getRoleTransaction() {
		return roleTransaction;
	}

	public void setRoleTransaction(RoleTransaction roleTransaction) {
		this.roleTransaction = roleTransaction;
	}

	
}
