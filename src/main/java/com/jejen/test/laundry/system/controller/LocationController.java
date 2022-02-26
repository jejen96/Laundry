package com.jejen.test.laundry.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jejen.test.laundry.system.dao.OutletDao;
import com.jejen.test.laundry.system.model.Absent;
import com.jejen.test.laundry.system.model.Outlet;

@Controller
@RequestMapping(value = "location")
public class LocationController {
	
	@Autowired
	OutletDao outletDao;
	
	
	String view;
	
	@RequestMapping(value = "viewlocation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView viewLocation() {
		ModelAndView views = new ModelAndView("location/viewLocation");
		
		List<Outlet> outlets = outletDao.getAllDataOutlet();
		int nomor = 1;
		
		view = "/location";
		views.addObject("view", view);
		views.addObject("outlets", outlets);
		views.addObject("nomor", nomor);
		return views;
		}
	
	
	 @RequestMapping(value = "uploadExcelFile", method = RequestMethod.POST)
		public String uploadDoc(ModelMap model,@RequestParam("file") MultipartFile file) {
		 try {
			
		LocalDateTime myDateObj = LocalDateTime.now();  
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");  
		String fileLocation = myDateObj.format(myFormatObj);
		
		 InputStream in = file.getInputStream();
		    File currDir = new File("D:\\sidejob\\Testfile\\"+fileLocation+"");
		    
		    String path = currDir.getAbsolutePath();
		    fileLocation = path.substring(0)+"-"+ file.getOriginalFilename();
		    
		    FileOutputStream f = new FileOutputStream(fileLocation);
		    int ch = 0;
		    while ((ch = in.read()) != -1) {
		        f.write(ch);
		    }
		    f.flush();
		    f.close();
	    
		    FileInputStream fis = new FileInputStream(fileLocation);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Row row;
	        for(int i=1; i<=sheet.getLastRowNum(); i++){  //points to the starting of excel i.e excel first row
	            row = (Row) sheet.getRow(i);  //sheet number
	            
	            if (!(row.getCell(0) == null)) {
					
				
		            String id;
					if( row.getCell(0)==null) { id = "0"; }
		            else id= row.getCell(0).toString();
					
	                   String nameEmployee;
					if( row.getCell(1)==null) { nameEmployee = "null";}  //suppose excel cell is empty then its set to 0 the variable
	                   else nameEmployee = row.getCell(1).toString();   //else copies cell data to name variable
						
					
	                   Date date;
					if( row.getCell(2)== null) { date = null;}
	                   else  date   = row.getCell(2).getDateCellValue();
					System.out.println(date);
					
					
					 Date inWork, inHour = null;
						if( !(row.getCell(3)== null)) {
							inWork   = row.getCell(3).getDateCellValue();
							
							SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
							String dateString = format.format(inWork);
							inHour = format.parse(dateString);
							
							String inHourOfWork = "08:00:00";
							Date hourOfWork = format.parse(inHourOfWork);
							
							long difference =   inHour.getTime() - hourOfWork.getTime();
							long diffSeconds = difference / 1000 % 60;
							long diffMinutes = difference / (60 * 1000) % 60;
							long diffHours = difference / (60 * 60 * 1000) % 24;
							
							if (hourOfWork.getTime() < inHour.getTime()) {
								String differenceIn = Long.toString(diffHours)+":"+Long.toString(diffMinutes)+":"+Long.toString(diffSeconds);
								
								Date differenceInHour = format.parse(differenceIn);
								
								System.out.println("jam karyawan masuk "+inHour);
								System.out.println("peraturan jam masuk karyawan "+hourOfWork);
								System.out.println(""+differenceInHour);
								
								if (diffHours > 0) {
									System.out.println("dipotong 50.000");
								}else if (diffMinutes > 15) {
									System.out.println("dipotong 10.000");
								}else if (diffMinutes > 30) {
									System.out.println("dipotong 20.00");
								}
							}
							  
						}else  { inWork = null;}
						
	            
						
						
						
						
				/*
				 * Time outWork; if( row.getCell(4)==null) { outWork = null; } else outWork =
				 * (Time) row.getCell(2);
				 */
						
						
		    Absent absent = new Absent();
		    absent.setIdEmployee(id);
		    absent.setNameEmployee(nameEmployee);
		    absent.setDateWork(date);
		    absent.setHourIn(inHour);
		    //absent.setHourOut(outWork);
		    System.out.println(absent.getIdEmployee() +" "+absent.getNameEmployee()+" "+absent.getDateWork()+" "+absent.getHourIn()+" "+absent.getHourOut());
		    //absentDao.save(absent);
		    	
	        }
	        }
			f.close();
	        
		    
		 } catch (Exception e) {
				e.printStackTrace();
			}
		 return "fileUploadView";
	}
	
}
