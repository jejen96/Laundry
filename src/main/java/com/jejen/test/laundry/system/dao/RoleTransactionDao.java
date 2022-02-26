package com.jejen.test.laundry.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jejen.test.laundry.system.model.RoleTransaction;

@Repository
public interface RoleTransactionDao extends CrudRepository<RoleTransaction, Integer> {
	
	@Query("from RoleTransaction order by id DESC")
	public List<RoleTransaction> getAllDataRoleTransaction();
	
	@Query("from RoleTransaction where id = :id")
	public RoleTransaction GetDataBasedOnIdRoleTransaction(@Param("id")long id);
	
}
