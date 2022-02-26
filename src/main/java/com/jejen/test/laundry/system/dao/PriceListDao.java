package com.jejen.test.laundry.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jejen.test.laundry.system.model.PriceList;

@Repository
public interface PriceListDao extends CrudRepository<PriceList, Integer> {
	
	@Query("from PriceList order by id DESC")
	public List<PriceList> getAllDataPriceList();
	
	@Query("from PriceList where idPriceList = :id")
	public PriceList GetDataBasedOnIdPriceList(@Param("id")long idPriceList);
	
}
