package com.jejen.test.laundry.system.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jejen.test.laundry.system.common.CommonCons;
import com.jejen.test.laundry.system.model.OrderTransaction;
import com.jejen.test.laundry.system.utils.GenerateReportReceipt;
import com.lowagie.text.pdf.PdfWriter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

@Controller
@SessionAttributes
@RequestMapping(value = "")
public class ReportController {
	
	@RequestMapping(value = "report", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	
	
	public void generate(@RequestBody OrderTransaction orderTransaction, HttpServletResponse response, long fileName) { 
		
		
		response.setContentType("application/pdf"); 
		response.setHeader("Content-disposition","attachment; filename="+fileName+".pdf");
		
		try {
			
			//proses maping dan generate jasperreports
			JasperPrint jPrint = new GenerateReportReceipt(orderTransaction).getReport();
			
			JRPdfExporter exporter = new JRPdfExporter();
			java.io.File sourceFile = new java.io.File(CommonCons.REPORT_PDF+"PdfReport.jrprint");
			
			java.io.File destFile = new java.io.File(sourceFile.getParent(), fileName + ".pdf");
			
			exporter.setExporterInput(new SimpleExporterInput(jPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			configuration.setPermissions(PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING);
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			
			
			ServletOutputStream outServlet = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jPrint, outServlet);
			
			outServlet.flush();
	        outServlet.close();
		
	        
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	
	}
}