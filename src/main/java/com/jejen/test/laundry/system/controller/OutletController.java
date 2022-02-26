package com.jejen.test.laundry.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jejen.test.laundry.system.dao.OutletDao;
import com.jejen.test.laundry.system.model.Outlet;
import com.jejen.test.laundry.system.model.api.OutletApi;
import com.jejen.test.laundry.system.utils.ReturnData;


@Controller
@RequestMapping(value = "outlet")
public class OutletController {
	
	@Autowired
	OutletDao outletDao;
	
	String view;
	
	@RequestMapping(value = "addoutlet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView AddData() {
		ModelAndView add = new ModelAndView("outlet/addOutlet");
		
		view = "/outlet";
		add.addObject("view", view);
		return add;
		}
	
	@RequestMapping(value = "saveoutlet", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody 
	 ReturnData saveData(@RequestBody OutletApi outletApi, HttpServletRequest request) { 
		ReturnData rd = new ReturnData(); 
		try {
			Outlet outlet = outletDao.GetDataBasedOnIdOutlet(outletApi.getId());
			
			if (outlet == null) {
				
				Outlet outletAdd = new Outlet(); 
				
				outletAdd.setNameOutlet(outletApi.getNameOutlet());
				outletAdd.setAddressOutlet(outletApi.getAddressOutlet());
				outletAdd.setPhoneNumberOutlet(outletApi.getPhoneNumberOutlet());
				outletAdd.setLat(outletApi.getLat());
				outletAdd.setLng(outletApi.getLng());
				outletDao.save(outletAdd);
				
				rd.setSuccess(true);
				rd.setMessage("success");
			} else {
				
				 Outlet outletEdit = outletDao.GetDataBasedOnIdOutlet(outletApi.getId());
				 	
				 outletEdit.setNameOutlet(outletApi.getNameOutlet());
				 outletEdit.setAddressOutlet(outletApi.getAddressOutlet());
				 outletEdit.setPhoneNumberOutlet(outletApi.getPhoneNumberOutlet());
				 outletEdit.setLat(outletApi.getLat());
				 outletEdit.setLng(outletApi.getLng());
				 	outletDao.save(outletEdit);
				 
					rd.setSuccess(true);
					rd.setMessage("berhasil");
			}
			
			 } catch (Exception e) {
			 e.printStackTrace(); } 
		return rd; }

	@RequestMapping(value = "viewoutlet", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView ViewData() {
		ModelAndView mav = new ModelAndView("outlet/viewOutlet"); 
	 
	  List<Outlet> listDataOutlet = outletDao.getAllDataOutlet();
	  
	 
	  int no = 1;
	  view = "/outlet"; 
	  mav.addObject("view", view);
	  mav.addObject("listDataOutlet",listDataOutlet); 
	  mav.addObject("no", no);
	  return mav; }
	
	@RequestMapping(value = "getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  public ModelAndView getById(@PathVariable long id) {
			ModelAndView rd = new ModelAndView("outlet/updateOutlet");
			try {
				Outlet outlet = outletDao.GetDataBasedOnIdOutlet(id);
				
				view = "/outlet";
				rd.addObject("view", view);
				rd.addObject("outlet", outlet);
				
			} catch (Exception e) {	
				e.printStackTrace();
				}
			return rd;
	  }
	
	/*
	 * @RequestMapping(value = "editoutlet", method = RequestMethod.POST, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public @ResponseBody ReturnData
	 * EditData(@RequestBody OutletApi outletApi, HttpServletRequest request) {
	 * ReturnData rd = new ReturnData(); try { Outlet outlet =
	 * outletDao.GetDataBasedOnIdOutlet(outletApi.getId());
	 * 
	 * outlet.setNameOutlet(outletApi.getNameOutlet());
	 * outlet.setAddressOutlet(outletApi.getAddressOutlet());
	 * outlet.setPhoneNumberOutlet(outletApi.getPhoneNumberOutlet());
	 * outletDao.save(outlet);
	 * 
	 * rd.setSuccess(true); rd.setMessage("berhasil");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return rd; }
	 */
}
