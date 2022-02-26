package com.jejen.test.laundry.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jejen.test.laundry.system.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	@Query("from User order by id DESC")
	public List<User> getAllDataUser();
	
	@Query("from User where id = :id")
	public User GetDataBasedOnIdUser(@Param("id")long id);
	
}
