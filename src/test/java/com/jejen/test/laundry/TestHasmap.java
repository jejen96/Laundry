package com.jejen.test.laundry;

import java.util.ArrayList;
import java.util.HashMap;

public class TestHasmap {
	public static void main(String args []){
		 HashMap<String, String> listData = new HashMap<String, String>();
		 
		 listData.put("name", "jejen");
		 listData.put("address", "Bandung");
		 
		 System.out.println("Nama : "+listData.get("name"));
		 System.out.println("Alamat : "+listData.get("address"));
		 System.out.println(listData);
		 
		 HashMap<String, ArrayList> dataHash = new HashMap<String, ArrayList>();
		 ArrayList<String> dataList = new ArrayList<String>();
		 
		 dataList.add("Islam");
		 dataList.add("Kristen");
		 dataList.add("Budha");
		 
		 dataHash.put("agama", dataList);
		 System.out.println(dataList);
		 
		 System.out.println(dataHash);
	}
}
