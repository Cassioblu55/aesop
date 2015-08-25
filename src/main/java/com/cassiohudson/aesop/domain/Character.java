package com.cassiohudson.aesop.domain;

import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.generator.Assest;
import com.cassiohudson.aesop.generator.CharacterStats;
import com.cassiohudson.aesop.generator.Name;

public class Character implements Assest{
	
	private Name name;
	private CharacterStats stats;
	private HashMap<CharacterTraitType, String> hash;
	
	public Character(CharacterStats stats, HashMap<CharacterTraitType, String> hash){
		this.name = new Name(stats.getGender());;
		this.stats = stats;
		this.hash = hash;
	}
	
	public String getTraits(){
		String s = new String();
		for(CharacterTraitType t : hash.keySet()){
			s = s.concat(Aesop.addLine(CharacterTraitType.getDisplay(t).concat(": ").concat(hash.get(t))));
		}
		return s;
	}
	
	public String getBio(){
		return this.name.getNameBio().concat(this.stats.getBio()).concat(this.getTraits());
	}

	public Name getName() {
		return name;
	}

	@Override
	public String getFileName() {
		return this.name.getFileName();
	}

	public CharacterStats getStats() {
		return stats;
	}

	public void setStats(CharacterStats stats) {
		this.stats = stats;
	}
	
	
	
	

}
