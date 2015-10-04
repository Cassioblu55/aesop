package com.cassiohudson.aesop.CSVResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.CharacterTraitType;

public class CharacterResources {

	private static final String PATH = "characters//"; 
	
	private static String findPath(String middle){
		return PATH.concat(middle);
	}
	
	public static List<String> getFemaleFirstName() throws IOException{
		return ReadFromCSV.getList(findPath("femaleFirstNames"));	
    }
	
	public static List<String> getMaleFirstName() throws IOException{
		return ReadFromCSV.getList(findPath("maleFirstNames"));	
    }
	
	public static List<String> getAppearence() throws IOException{
		return ReadFromCSV.getList(findPath("appearance"));	
    }
	
	public static List<String> getLastName() throws IOException{
		return ReadFromCSV.getList(findPath("lastNames"));	
    }

	public static List<String> getAblity() throws IOException {
		return ReadFromCSV.getList(findPath("abilities"));	
	}

	public static List<String> getTalent() throws IOException {
		return ReadFromCSV.getList(findPath("talent"));	
	}
	
	public static List<String> getInteractionTrait() throws IOException {
		return ReadFromCSV.getList(findPath("interactionTrait"));	
	}

	public static List<String> getMannerisms() throws IOException {
		return ReadFromCSV.getList(findPath("mannerism"));	
	}
	
	public static List<String> getIdeals() throws IOException {
		return ReadFromCSV.getList(findPath("ideal"));	
	}
	
	public static List<String> getBonds() throws IOException {
		return ReadFromCSV.getList(findPath("bond"));	
	}

	public static List<String> getFlaws() throws IOException {
		return ReadFromCSV.getList(findPath("flaw"));	
	}
	
	public static HashMap<CharacterTraitType, List<String>> getAllData() throws IOException{
		HashMap<CharacterTraitType, List<String>> hash = new HashMap<CharacterTraitType, List<String>>();
		hash.put(CharacterTraitType.ability, getAblity());
		hash.put(CharacterTraitType.appearance, getAppearence());
		hash.put(CharacterTraitType.bond, getBonds());
		hash.put(CharacterTraitType.flaw, getFlaws());
		hash.put(CharacterTraitType.ideal, getIdeals());
		hash.put(CharacterTraitType.interaction, getInteractionTrait());
		hash.put(CharacterTraitType.mannerism, getMannerisms());
		hash.put(CharacterTraitType.talent, getTalent());
		return hash;
	}
	
	
}
