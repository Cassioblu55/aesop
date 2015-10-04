package com.cassiohudson.aesop.CSVResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.CharacterTraitType;

public class CharacterAssets {

private static final String PATH = "characters//"; 
	
	public static List<String> getTraits(String type) throws IOException {
		return ReadFromCSV.getList(PATH.concat(type));	
	}
	
	public static HashMap<CharacterTraitType, List<String>> getAllData() throws IOException {
		HashMap<CharacterTraitType, List<String>> hash = new HashMap<CharacterTraitType, List<String>>();
		for(CharacterTraitType t : CharacterTraitType.values()){
			hash.put(t, getTraits(t.toString()));
		}
		return hash;
	}
	
}
