package com.jejen.test.laundry.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jejen.test.laundry.system.model.SubOrderTransaction;

@Repository
public interface SubOrderTransactionDao extends CrudRepository<SubOrderTransaction, Integer> {
	
	@Query("from SubOrderTransaction order by id DESC")
	public List<SubOrderTransaction> getAllDataSubOrderTransaction();
	
	@Query("from SubOrderTransaction where idSubOrderTransaction = :id")
	public SubOrderTransaction GetDataBasedOnIdSubOrderTransaction(@Param("id")long idSubOrderTransaction);
	
	@Query("from SubOrderTransaction where idOrderTransaction = :idOrderTransaction")
	public List<SubOrderTransaction> getIdSubOrderTransaction(@Param("idOrderTransaction")long idOrderTransaction);
	
}
