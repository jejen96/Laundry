package com.jejen.test.laundry.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_transaction")
public class RoleTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, columnDefinition = "serial")
	private long id;
	
	@Column(name = "name_role_transaction")
	private String nameRoleTransaction;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameRoleTransaction() {
		return nameRoleTransaction;
	}

	public void setNameRoleTransaction(String nameRoleTransaction) {
		this.nameRoleTransaction = nameRoleTransaction;
	}

	
	}
