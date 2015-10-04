package com.cassiohudson.aesop.domain;

import java.util.HashMap;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.generator.Assest;

public class Tavern implements Assest {

	private HashMap<TavenTraitType, String> hash;
	
	public Tavern(HashMap<TavenTraitType, String> hash){
		this.hash = hash;
	}
	
	
	public String getBio() {
		String bio = Aesop.addLine(hash.get(TavenTraitType.first_name).concat(" ").concat(hash.get(TavenTraitType.last_name)));
		bio = bio.concat(Aesop.addLine(hash.get(TavenTraitType.type)));
		return bio;
	}

	
	public String getFileName() {
		String firstName = hash.get(TavenTraitType.first_name).replace(" ", "_");
		String lastName = hash.get(TavenTraitType.last_name).replace(" ", "_");
		return firstName.concat("_").concat(lastName).concat(Aesop.TXT_EXT);
	}

}
