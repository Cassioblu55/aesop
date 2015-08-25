package com.cassiohudson.aesop.domain;

import java.util.HashMap;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.generator.VillianTrait;

public class Villain {

	private Character character;
	private HashMap<VillainTraitType, VillianTrait> traits;
	
	public Villain(HashMap<VillainTraitType, VillianTrait> traits, Character character){
		this.traits = traits;
		this.character = character;
	}
	
	public String getBio(){
		String s = new String();
		s = s.concat(Aesop.addLine(character.getName().getNameBio()));
		s = s.concat(Aesop.addLine(character.getStats().getBio()));
		s=s.concat(Aesop.addLine("Villian Traits:"));
		s = s.concat(Aesop.addLine(getTraits()));
		s=s.concat(Aesop.addLine("Character Traits:"));
		s = s.concat(Aesop.addLine(character.getTraits()));
		return s;
	}
	
	
	private String getTraits(){
		String s = new String();
		for(VillainTraitType t : traits.keySet()){
			s = s.concat(Aesop.addLine(VillainTraitType.getDisplay(t).concat(": ").concat(traits.get(t).getBio())));
		}
		return s;
	}
	
	public String getFileName(){
		return character.getFileName();
	}
	
	
}
