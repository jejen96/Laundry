package com.jejen.test.laundry.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jejen.test.laundry.system.model.OrderTransaction;

@Repository
public interface OrderTransactionDao extends CrudRepository<OrderTransaction, Integer> {
	
	@Query("from OrderTransaction order by id DESC")
	public List<OrderTransaction> getAllDataOrder();
	
	@Query("from OrderTransaction where id = :id")
	public OrderTransaction GetDataBasedOnIdOrder(@Param("id")long id);
	
	
}
