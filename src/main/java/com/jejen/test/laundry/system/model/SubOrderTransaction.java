package com.jejen.test.laundry.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_order_transaction")
public class SubOrderTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, columnDefinition = "serial")
	private long idSubOrderTransaction;
	
	@ManyToOne
	@JoinColumn(name = "price")
	private PriceList priceOrder;
	
	@Column(name = "kilo_gram")
	private long kiloGram;
	
	@Column(name = "amount_order")
	private long amountOrder;
	
	@Column(name = "id_order_transaction")
	private long idOrderTransaction;

	public long getIdSubOrderTransaction() {
		return idSubOrderTransaction;
	}

	public void setIdSubOrderTransaction(long idSubOrderTransaction) {
		this.idSubOrderTransaction = idSubOrderTransaction;
	}

	public PriceList getPriceOrder() {
		return priceOrder;
	}

	public void setPriceOrder(PriceList priceOrder) {
		this.priceOrder = priceOrder;
	}

	public long getKiloGram() {
		return kiloGram;
	}

	public void setKiloGram(long kiloGram) {
		this.kiloGram = kiloGram;
	}

	public long getAmountOrder() {
		return amountOrder;
	}

	public void setAmountOrder(long amountOrder) {
		this.amountOrder = amountOrder;
	}

	public long getIdOrderTransaction() {
		return idOrderTransaction;
	}

	public void setIdOrderTransaction(long idOrderTransaction) {
		this.idOrderTransaction = idOrderTransaction;
	}
	
	}
