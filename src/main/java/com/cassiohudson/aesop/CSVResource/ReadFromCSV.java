package com.cassiohudson.aesop.CSVResource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class ReadFromCSV {
	
	public static final List<String> getList(String middle){
		String fileName = findPath(middle);
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader	br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitData = line.split("\\s*,\\s*");
				for (int i = 0; i < splitData.length; i++) {
					if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
						list.add(splitData[i].trim());
					}
				}
			}
		ConnectionUtils.close(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String getRandom(String middle) throws IOException{
		List<String> list = getList(middle);
		return list.get(new Random().nextInt(list.size()));
	}
	
	private static String findPath(String middle){
		return Aesop.RESOURCE_PATH.concat(middle).concat(Aesop.CSV_EXT);
	}
	
}
