package com.cassiohudson.aesop.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.CSVResource.CharacterResources;
import com.cassiohudson.aesop.CSVResource.SettelementResources;
import com.cassiohudson.aesop.CSVResource.TavenResources;
import com.cassiohudson.aesop.domain.CharacterTraitType;
import com.cassiohudson.aesop.domain.SettelemntTraitType;
import com.cassiohudson.aesop.domain.TavenTraitType;

public class InsertAllCSVData {

//	public static void insertChracterTraits(){
//		CharacterTraitHome cth = new CharacterTraitHome();
//		try {
//			HashMap<CharacterTraitType, List<String>> hash = CharacterAssets.getAllData();
//			for(CharacterTraitType t : hash.keySet()){
//				cth.insertTraitByType(t.toString(), hash.get(t));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void insertSettelmentTraits(){
		SettelementTraitHome cth = new SettelementTraitHome();
		try {
			HashMap<SettelemntTraitType, List<String>> hash = SettelementResources.getAllData();
			for(SettelemntTraitType t : hash.keySet()){
				cth.insertTraitByType(t.toString(), hash.get(t));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertTavernTraits(){
		TavernTraitHome cth = new TavernTraitHome();
		try {
			HashMap<TavenTraitType, List<String>> hash = TavenResources.getAllData();
			for(TavenTraitType t : hash.keySet()){
				cth.insertTraitByType(t.toString(), hash.get(t));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

