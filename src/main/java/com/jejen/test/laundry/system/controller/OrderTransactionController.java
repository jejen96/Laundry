package com.jejen.test.laundry.system.controller;

import java.io.FileOutputStream;
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

import com.jejen.test.laundry.system.dao.OrderTransactionDao;
import com.jejen.test.laundry.system.dao.OutletDao;
import com.jejen.test.laundry.system.dao.PriceListDao;
import com.jejen.test.laundry.system.dao.RoleTransactionDao;
import com.jejen.test.laundry.system.dao.SubOrderTransactionDao;
import com.jejen.test.laundry.system.model.OrderTransaction;
import com.jejen.test.laundry.system.model.Outlet;
import com.jejen.test.laundry.system.model.PriceList;
import com.jejen.test.laundry.system.model.RoleTransaction;
import com.jejen.test.laundry.system.model.SubOrderTransaction;
import com.jejen.test.laundry.system.model.api.OrderTransactionApi;
import com.jejen.test.laundry.system.model.api.SubOrderTransactionApi;
import com.jejen.test.laundry.system.utils.ReturnData;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


@Controller
@RequestMapping(value = "order")
public class OrderTransactionController {
	
	@Autowired
	OrderTransactionDao orderTransactionDao;
	@Autowired
	OutletDao outletDao;
	@Autowired
	RoleTransactionDao roleTransactionDao;
	@Autowired
	PriceListDao priceListDao;
	@Autowired
	SubOrderTransactionDao subOrderTransactionDao;
	
	String view;
	
	@RequestMapping(value = "addorder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView AddData() {
		ModelAndView add = new ModelAndView("orderTransaction/addOrderTransaction");
		
		view = "/order";
		add.addObject("view", view);
		return add;
		}
	
	@RequestMapping(value = "saveorder", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody 
	 ReturnData saveData(@RequestBody OrderTransactionApi orderTransactionApi, HttpServletRequest request) { 
		ReturnData rd = new ReturnData(); 
		try {
			
			OrderTransaction orderTransaction = orderTransactionDao.GetDataBasedOnIdOrder(orderTransactionApi.getIdOrderTransaction());
			
			if (orderTransaction == null) {
				
				long idOutlet = 1;
				long idRoleTransaction = 1;
				
				OrderTransaction orderTransactionAdd = new OrderTransaction(); 
				
				Outlet outlet = outletDao.GetDataBasedOnIdOutlet(idOutlet);
				RoleTransaction roleTransaction = roleTransactionDao.GetDataBasedOnIdRoleTransaction(idRoleTransaction);
				
				orderTransactionAdd.setNameOrder(orderTransactionApi.getNameOrder());
				orderTransactionAdd.setAddressOrder(orderTransactionApi.getAddressOrder());
				orderTransactionAdd.setPhoneNumberOrder(orderTransactionApi.getPhoneNumberOrder());
				orderTransactionAdd.setTimePickup(orderTransactionApi.getTimePickup());
				orderTransactionAdd.setRoleTransaction(roleTransaction);
				orderTransactionAdd.setOutlet(outlet); // dari outlet saat outlet tersebut login atau dari pelanggan saat menemukan outlet terdekat
				orderTransactionDao.save(orderTransactionAdd);
				
				rd.setSuccess(true);
				rd.setMessage("success");
			}else {
				long tot = 0;
				long idRoleTransaction = 2;
				
				OrderTransaction orderTransactionEdit = orderTransactionDao.GetDataBasedOnIdOrder(orderTransactionApi.getIdOrderTransaction());
					long idorder = orderTransactionEdit.getId();
				
				List<SubOrderTransaction> subOrderTransactions = subOrderTransactionDao.getIdSubOrderTransaction(idorder);
					for(SubOrderTransaction jum : subOrderTransactions) // for ngambil data dari database
						tot += (jum.getAmountOrder());
				 
				RoleTransaction roleTransaction = roleTransactionDao.GetDataBasedOnIdRoleTransaction(idRoleTransaction);
				
				orderTransactionEdit.setTotalAmountOrder(tot);
				orderTransactionEdit.setRoleTransaction(roleTransaction);
				orderTransactionDao.save(orderTransactionEdit);
				rd.setSuccess(true);
				rd.setMessage("success");
			}
			 
			 } catch (Exception e) {
			 e.printStackTrace(); } 
		return rd; }
	
	@RequestMapping(value = "vieworder", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE) 
	public ModelAndView ViewData() {
		ModelAndView mav = new ModelAndView("orderTransaction/viewOrderTransaction"); 
		
		 List<OrderTransaction> listDataOrder = orderTransactionDao.getAllDataOrder();
	  
	  view = "/order"; 
	  int no = 1;
	  mav.addObject("view", view);
	  mav.addObject("listDataOrder",listDataOrder); 
	  mav.addObject("no", no);
	  return mav; }
	
	@RequestMapping(value = "getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  public ModelAndView getById(@PathVariable long id) {
			ModelAndView rd = new ModelAndView("orderTransaction/itemOrder");
			try {
					
					OrderTransaction orderTransaction = orderTransactionDao.GetDataBasedOnIdOrder(id);
					long idorder = orderTransaction.getId();
					List<PriceList> pricelist = priceListDao.getAllDataPriceList();
					List<SubOrderTransaction> subOrderTransactions = subOrderTransactionDao.getIdSubOrderTransaction(idorder);
					int nomor = 1;
					
					view = "/order";
					rd.addObject("view", view);
					rd.addObject("orderTransaction", orderTransaction);
					rd.addObject("pricelist", pricelist);
					rd.addObject("subOrderTransactions", subOrderTransactions);
					rd.addObject("nomor", nomor);
				
			} catch (Exception e) {	
				e.printStackTrace();
				}
			return rd;
	  }
	
	 @RequestMapping(value = "tambah", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ReturnData EditData(@RequestBody SubOrderTransactionApi subOrderTransactionApi, HttpServletRequest request) {
			ReturnData rd = new ReturnData();
			try {
					SubOrderTransaction subOrderTransactionId = subOrderTransactionDao.GetDataBasedOnIdSubOrderTransaction(subOrderTransactionApi.getIdSubOrderTransaction());
				 			
					if (subOrderTransactionId == null) {
					
						SubOrderTransaction subOrderTransaction = new SubOrderTransaction();
					 	
					 	 //mendapatkan id dari database
						PriceList priceList = priceListDao.GetDataBasedOnIdPriceList(subOrderTransactionApi.getPriceOrder()); 	
						long price = priceList.getPriceList();

					 	long kg = subOrderTransactionApi.getKiloGram();
					 	long amount = price * kg;
					 
					 subOrderTransaction.setIdOrderTransaction(subOrderTransactionApi.getIdOrderTransaction());
					 subOrderTransaction.setPriceOrder(priceList);
					 subOrderTransaction.setKiloGram(subOrderTransactionApi.getKiloGram());
					 subOrderTransaction.setAmountOrder(amount);
					 subOrderTransactionDao.save(subOrderTransaction);
					 
					 rd.setSuccess(true);
					 rd.setMessage("success");
					}else {
					
						SubOrderTransaction subOrderTransaction = subOrderTransactionDao.GetDataBasedOnIdSubOrderTransaction(subOrderTransactionApi.getIdSubOrderTransaction());
					
						PriceList priceList = priceListDao.GetDataBasedOnIdPriceList(subOrderTransactionApi.getPriceOrder()); 	
						long price = priceList.getPriceList();

					 	long kg = subOrderTransactionApi.getKiloGram();
					 	long amount = price * kg;
					 	
						 subOrderTransaction.setPriceOrder(priceList);
						 subOrderTransaction.setKiloGram(subOrderTransactionApi.getKiloGram());
						 subOrderTransaction.setAmountOrder(amount);
						 subOrderTransactionDao.save(subOrderTransaction);
						 
						 rd.setSuccess(true);
						 rd.setMessage("success");
					}
				 	
			} catch (Exception e) {
			e.printStackTrace();
			}
			return rd;
	 		}
	 
	 @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  public ModelAndView getByIdProses(@PathVariable long id) {
			ModelAndView mav = new ModelAndView("orderTransaction/viewOrderTransaction");
			try {
				
				List<OrderTransaction> listDataOrder = orderTransactionDao.getAllDataOrder();
				  
				  view = "/order"; 
				  mav.addObject("view", view);
				  mav.addObject("listDataOrder",listDataOrder);
				
				OrderTransaction orderTransaction = orderTransactionDao.GetDataBasedOnIdOrder(id);
				RoleTransaction idtrx = orderTransaction.getRoleTransaction();
					long idproses = idtrx.getId();
				
				if (idproses == 2) {

					OrderTransaction orderTransactionProses = orderTransactionDao.GetDataBasedOnIdOrder(id);
					
					long idRoleTransaction = 3;
					RoleTransaction roleTransaction = roleTransactionDao.GetDataBasedOnIdRoleTransaction(idRoleTransaction);

					orderTransactionProses.setRoleTransaction(roleTransaction);
					orderTransactionDao.save(orderTransactionProses);
					
				} else if (idproses == 3) {
					
					OrderTransaction orderTransactionSelesai = orderTransactionDao.GetDataBasedOnIdOrder(id);
					
					long idRoleTransaction = 4;	
					RoleTransaction roleTransaction = roleTransactionDao.GetDataBasedOnIdRoleTransaction(idRoleTransaction);

					orderTransactionSelesai.setRoleTransaction(roleTransaction);
					orderTransactionDao.save(orderTransactionSelesai);
					
				} else {
					System.out.println("tidak ada status");
				}
				
			} catch (Exception e) {	
				e.printStackTrace();
				}
			return mav;
	  }
	 
	 @RequestMapping(value = "getById/getByItem/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  public ModelAndView getByIdSub(@PathVariable long id) {
			ModelAndView rd = new ModelAndView("orderTransaction/editItemOrder");
			try {
				
			SubOrderTransaction subOrderTransactions = subOrderTransactionDao.GetDataBasedOnIdSubOrderTransaction(id);
			long idOrder = subOrderTransactions.getIdOrderTransaction();
			List<PriceList> pricelist = priceListDao.getAllDataPriceList();
			
			view = "/order";
			rd.addObject("view", view);
			rd.addObject("pricelist", pricelist);
			rd.addObject("subOrderTransactions", subOrderTransactions);
			rd.addObject("idOrder", idOrder);
			
			} catch (Exception e) {	
				e.printStackTrace();
				}
			return rd;
	  }
	 
	 @RequestMapping(value = "kwitansi/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ModelAndView kwitansi(@PathVariable long id) {
		 ModelAndView mav = new ModelAndView("orderTransaction/viewOrderTransaction");
			
			try {
				Document document = new Document();
				PdfWriter.getInstance(document,new FileOutputStream("D:\\jejen\\latihan.pdf"));
					  document.open();
					  document.add(new Paragraph("jejen"));
					  document.close();
				
			} catch (Exception e) {	
				e.printStackTrace();
			}
			return mav;	
		}
	 
}
			
