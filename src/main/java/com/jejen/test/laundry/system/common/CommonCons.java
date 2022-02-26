package com.jejen.test.laundry.system.common;

import java.io.File;

public class CommonCons {

	public static final String data = "";

	//export to PDF
	
	
	//export to Excel
	public static int LIMIT_PER_PAGE = 10;
	public static String ROOT_DIR = "D:\\jejen\\laundry\\jrxml";
	
	
	public static String UPLOAD_FILE_DIR = ROOT_DIR + "UPLOAD_FILE" + File.separator;
	
	public static String REPORT_PDF = ROOT_DIR + "PDF/";
	
	//Image dir header
	public static String IMAGE_DIR = ROOT_DIR + "PDF\\image/";
	
	//template
	public static String templateReportTrouble = "Report_Trouble.xlsx";

	public static String EMAIL_SENDER = "jejen@gmail.com";
	public static String EMAIL_RECIPIENT = "jejen@gmail.com";
	
	//location
	public static String ROOT_PDF = "D:\\wavecomindo\\drules\\jrxml";
	public static String REPORT_SALLARY = ROOT_PDF + "PDF/"; 
}
