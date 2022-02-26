package com.jejen.test.laundry.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jejen.test.laundry.system.dao.UserDao;
import com.jejen.test.laundry.system.model.User;
import com.jejen.test.laundry.system.model.api.UserApi;
import com.jejen.test.laundry.system.utils.ReturnData;


@Controller
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	String view;
	
	@RequestMapping(value = "viewuser", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView ViewData() {
		ModelAndView mav = new ModelAndView("user/viewuser"); 
	 
		// Get All User No 3
	  List<User> listUser = userDao.getAllDataUser();
	  
	  view = "/user"; 
	  mav.addObject("view", view);
	  mav.addObject("listUser",listUser); 
	  return mav; }
	
	@RequestMapping(value = "signIn", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody 
	 ReturnData SignInData(@RequestBody UserApi userApi, HttpServletRequest request) { 
		ReturnData rd = new ReturnData();
		
		//Sign In No 2
		
		User user = userDao.GetDataBasedOnIdUser(userApi.getId());
		
		return rd;
	}
	
	@RequestMapping(value = "signUp", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody 
	 ReturnData SignUpData(@RequestBody UserApi userApi, HttpServletRequest request) { 
		ReturnData rd = new ReturnData();
		
		//sign Up User No 1
		User addUser = new User();
		
		addUser.setUsername(userApi.getUsername());
		addUser.setEncryptedPassword(userApi.getEncryptedPassword());
		addUser.setAddress(userApi.getAddress());
		addUser.setName(userApi.getName());
		addUser.setPostcode(userApi.getPostcode());
		addUser.setEmail(userApi.getEmail());
		addUser.setPhone(userApi.getPhone());
		addUser.setCountry(userApi.getCountry());
		addUser.setCity(userApi.getCity());
		userDao.save(addUser);
		
		rd.setMessage("success");
		rd.setSuccess(true);
		return rd;
	}
}
