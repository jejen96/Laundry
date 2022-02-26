package com.jejen.test.laundry.system.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.jejen.test.laundry.system.common.CommonCons;
import com.jejen.test.laundry.system.dao.OrderTransactionDao;
import com.jejen.test.laundry.system.model.OrderTransaction;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class GenerateReportReceipt {

	@Autowired
	OrderTransactionDao orderTransactionDao;
	
	private OrderTransaction orderTransaction;
	public GenerateReportReceipt(OrderTransaction orderTransaction) {
		
		this.orderTransaction = orderTransaction;
	}
	
	public JasperPrint getReport() {
		String fileJasper ="";
		
		fileJasper = CommonCons.REPORT_PDF + "InvoiceZonasikucek.jrxml";
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String inDate = sdf.format(date);
		
		String nameOrder = "";
		nameOrder = orderTransaction.getNameOrder();
		
		param.put("order_name",nameOrder);
		param.put("date", inDate);
		
		try {
			
			JasperReport jRpt = JasperCompileManager.compileReport(fileJasper);
			JasperPrint jPrint = JasperFillManager.fillReport(jRpt, param,
					new JREmptyDataSource());

			System.out.println("Print success");

		
			return jPrint;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}

		
	}
}

