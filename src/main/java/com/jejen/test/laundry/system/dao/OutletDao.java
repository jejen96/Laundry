package com.jejen.test.laundry.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jejen.test.laundry.system.model.Outlet;

@Repository
public interface OutletDao extends CrudRepository<Outlet, Integer> {
	
	@Query("from Outlet order by id DESC")
	public List<Outlet> getAllDataOutlet();
	
	@Query("from Outlet where id = :id")
	public Outlet GetDataBasedOnIdOutlet(@Param("id")long id);
	
}
