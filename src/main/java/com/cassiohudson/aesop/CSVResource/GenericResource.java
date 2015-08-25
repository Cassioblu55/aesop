package com.cassiohudson.aesop.CSVResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenericResource {

	private String path;
	
	public GenericResource(String path){
		this.path = path;
	}
	
	//Will return all of the data found in a csv file divided into columns from list of column names
	public HashMap<String, List<String>> getCSVRowHash(String type, List<String> rows){
		HashMap<String, List<String>> hash = getMasterHash(rows);
		List<String> dataList = ReadFromCSV.getList(path.concat(type));
		int counter = 0;
		for(String row : dataList){
			List<String> columnList =hash.get(rows.get(counter));
			columnList.add(row);
			if(counter<rows.size()-1){counter++;}
			else{counter=0;}
		}
		return hash;
	}
	
	//Creates a HashMap<String, List<String> and fills it with empty lists
	public static HashMap<String, List<String>> getMasterHash(List<String> rows){
		HashMap<String, List<String>> hash = new HashMap<String, List<String>>();
		for(String row : rows){
			List<String> list = new ArrayList<String>();
			hash.put(row, list);
		}
		return hash;
	}

}
