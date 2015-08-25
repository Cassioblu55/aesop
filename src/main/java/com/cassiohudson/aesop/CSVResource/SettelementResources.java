package com.cassiohudson.aesop.CSVResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.SettelemntTraitType;
import com.cassiohudson.aesop.generator.Aesop;

public class SettelementResources {

	private static final String PATH = "settelements//"; 
	
	public static List<String> getTraits(String type) throws IOException {
		return ReadFromCSV.getList(PATH.concat(type));	
	}
	
	public static HashMap<SettelemntTraitType, List<String>> getAllData() throws IOException {
		HashMap<SettelemntTraitType, List<String>> hash = new HashMap<SettelemntTraitType, List<String>>();
		for(SettelemntTraitType t : SettelemntTraitType.values()){
			hash.put(t, getTraits(t.toString()));
		}
		return hash;
	}

}
