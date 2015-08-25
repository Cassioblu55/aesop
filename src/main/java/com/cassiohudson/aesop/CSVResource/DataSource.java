package com.cassiohudson.aesop.CSVResource;

import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.dao.CharacterTraitHome;
import com.cassiohudson.aesop.dao.CharacterTraitService;
import com.cassiohudson.aesop.dao.SettelementTraitHome;
import com.cassiohudson.aesop.dao.SettelementTraitService;
import com.cassiohudson.aesop.dao.TavernTraitHome;
import com.cassiohudson.aesop.dao.TavernTraitService;
import com.cassiohudson.aesop.domain.CharacterTrait;
import com.cassiohudson.aesop.domain.CharacterTraitType;
import com.cassiohudson.aesop.domain.SettelementTrait;
import com.cassiohudson.aesop.domain.SettelemntTraitType;
import com.cassiohudson.aesop.domain.TavenTraitType;
import com.cassiohudson.aesop.domain.TavernTrait;


public class DataSource {

	private static CharacterTraitService cts = new CharacterTraitHome();
	private static SettelementTraitService sts = new SettelementTraitHome();
	private static TavernTraitService tts = new TavernTraitHome();
	
	//public static final  HashMap<CharacterTraitType, List<CharacterTrait>> TRAIT_DATA = getCharacterData();
	public static final  HashMap<SettelemntTraitType, List<SettelementTrait>> SETTLEMENT_DATA = getSettelementData();
	//public static final HashMap<TavenTraitType, List<TavernTrait>> TAVERN_DATA = getTavernData();
	
//	private static HashMap<CharacterTraitType, List<CharacterTrait>> getCharacterData(){
//		HashMap<CharacterTraitType, List<CharacterTrait>> hash = new HashMap<CharacterTraitType, List<CharacterTrait>>();
//		for(CharacterTraitType t : CharacterTraitType.values()){
//			List<CharacterTrait> ctList = cts.findByType(t);
//			hash.put(t, ctList);
//		}
//		return hash;
//	}
	
//	private static HashMap<TavenTraitType, List<TavernTrait>> getTavernData() {
//		HashMap<TavenTraitType, List<TavernTrait>> hash = new HashMap<TavenTraitType, List<TavernTrait>>();
//		for(TavenTraitType t : TavenTraitType.values()){
//			List<TavernTrait> ttList = tts.findByType(t);
//			hash.put(t, ttList);
//		}
//		return hash;
//	}

	private static HashMap<SettelemntTraitType, List<SettelementTrait>> getSettelementData(){
		HashMap<SettelemntTraitType, List<SettelementTrait>> hash = new HashMap<SettelemntTraitType, List<SettelementTrait>>();
		for(SettelemntTraitType t : SettelemntTraitType.values()){
			List<SettelementTrait> ctList = sts.findByType(t);
			hash.put(t, ctList);
		}
		return hash;
	}
	
}
