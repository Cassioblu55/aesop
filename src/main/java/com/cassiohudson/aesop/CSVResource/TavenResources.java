package com.cassiohudson.aesop.CSVResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.TavenTraitType;
import com.cassiohudson.aesop.generator.Aesop;

public class TavenResources {

	private static final String PATH = "taverns//"; 
	
	public static List<String> getTraits(String type) throws IOException {
		return ReadFromCSV.getList(PATH.concat(type));	
	}
	
	public static HashMap<TavenTraitType, List<String>> getAllData() throws IOException {
		HashMap<TavenTraitType, List<String>> hash = new HashMap<TavenTraitType, List<String>>();
		for(TavenTraitType t : TavenTraitType.values()){
			hash.put(t, getTraits(t.toString()));
		}
		return hash;
	}

}
