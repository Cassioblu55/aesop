package com.cassiohudson.aesop.domain;

import java.util.HashMap;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.generator.Assest;

public class Tavern implements Assest {

	private HashMap<TavenTraitType, String> hash;
	
	public Tavern(HashMap<TavenTraitType, String> hash){
		this.hash = hash;
	}
	
	@Override
	public String getBio() {
		String bio = Aesop.addLine(hash.get(TavenTraitType.FIRST_NAME).concat(" ").concat(hash.get(TavenTraitType.LAST_NAME)));
		bio = bio.concat(Aesop.addLine(hash.get(TavenTraitType.TYPE)));
		return bio;
	}

	@Override
	public String getFileName() {
		String firstName = hash.get(TavenTraitType.FIRST_NAME).replace(" ", "_");
		String lastName = hash.get(TavenTraitType.LAST_NAME).replace(" ", "_");
		return firstName.concat("_").concat(lastName).concat(Aesop.TXT_EXT);
	}

}
