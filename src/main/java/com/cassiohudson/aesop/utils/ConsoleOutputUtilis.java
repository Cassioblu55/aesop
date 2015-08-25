package com.cassiohudson.aesop.utils;

import java.util.HashMap;
import java.util.List;

public class ConsoleOutputUtilis {

	public static void hashListOutput(HashMap<String, List<String>>hash ){
		for(String key : hash.keySet()){
			List<String> list = hash.get(key);
			for(String string : list){
				System.out.println(key.concat(": ")
						.concat(string));
			}	
		}
	}
	
	public static void hashOutput(HashMap<String, String> hash){
		for(String key : hash.keySet()){
			System.out.println(key.concat(": ")
					.concat(hash.get(key)));
		}
	}
	
	
}
