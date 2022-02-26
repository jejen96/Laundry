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

import com.jejen.test.laundry.system.dao.PriceListDao;
import com.jejen.test.laundry.system.model.PriceList;
import com.jejen.test.laundry.system.model.api.PriceListApi;
import com.jejen.test.laundry.system.utils.ReturnData;


@Controller
@RequestMapping(value = "pricelist")
public class PriceListController {
	
	@Autowired
	PriceListDao priceListDao;
	
	String view;
	
	@RequestMapping(value = "addpricelist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView AddData() {
		ModelAndView add = new ModelAndView("priceList/addPriceList");
		
		view = "/pricelist";
		add.addObject("view", view);
		return add;
		}
	
	@RequestMapping(value = "savepricelist", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody 
	 ReturnData saveData(@RequestBody PriceListApi priceListApi, HttpServletRequest request) { 
		ReturnData rd = new ReturnData(); 
		try {
			 PriceList priceList = 	priceListDao.GetDataBasedOnIdPriceList(priceListApi.getIdPriceList());
			 
			 if (priceList == null) {
				
				 PriceList priceListAdd = new PriceList(); 
					
					priceListAdd.setNamePriceList(priceListApi.getNamePriceList());
					priceListAdd.setPriceList(priceListApi.getPriceList());
					priceListDao.save(priceListAdd);
					
					rd.setSuccess(true);
					rd.setMessage("success");
			}else {
				
				PriceList priceListEdit = 	priceListDao.GetDataBasedOnIdPriceList(priceListApi.getIdPriceList());
			 	
				priceListEdit.setNamePriceList(priceListApi.getNamePriceList());
				priceListEdit.setPriceList(priceListApi.getPriceList());
				priceListDao.save(priceListEdit); 
			 
				rd.setSuccess(true);
				rd.setMessage("berhasil");
				
			}
			 } catch (Exception e) {
			 e.printStackTrace(); } 
		return rd; }

	@RequestMapping(value = "viewpricelist", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView ViewData() {
		ModelAndView mav = new ModelAndView("priceList/viewPriceList"); 
	 
	  List<PriceList> listDataPriceList = priceListDao.getAllDataPriceList();
	  
	  int no = 1;
	  view = "/pricelist"; 
	  mav.addObject("view", view);
	  mav.addObject("listDataPriceList",listDataPriceList); 
	  mav.addObject("no", no);
	  return mav; }
	
	@RequestMapping(value = "getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  public ModelAndView getById(@PathVariable long id) {
			ModelAndView rd = new ModelAndView("priceList/updatePriceList");
			try {
				PriceList priceList = priceListDao.GetDataBasedOnIdPriceList(id);
				
				view = "/pricelist";
				rd.addObject("view", view);
				rd.addObject("priceList", priceList);
				
			} catch (Exception e) {	
				e.printStackTrace();
				}
			return rd;
	  }
	
	
}
