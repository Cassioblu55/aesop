package com.cassiohudson.aesop.domain;

import java.util.HashMap;

import com.cassiohudson.aesop.generator.Aesop;

public class Dungeon {

	private HashMap<DungeonTraitType, DungeonTrait> traits;

	public Dungeon(HashMap<DungeonTraitType, DungeonTrait> traits){
		this.traits = traits;
	}
	
	public String getBio(){
		String bio = Aesop.addLine(traits.get(DungeonTraitType.NAME).getTrait());
		for(DungeonTraitType type : traits.keySet()){
			if(type != DungeonTraitType.NAME){
				bio = bio.concat(Aesop.nextLine(traits.get(type).getBio()));
			}
		}
		return bio;
	}
	
	public String getFileName(){
		return traits.get(DungeonTraitType.NAME).getTrait().replace(" ", "_").concat(Aesop.TXT_EXT);
	}

	public HashMap<DungeonTraitType, DungeonTrait> getTraits() {
		return traits;
	}

	public void setTraits(HashMap<DungeonTraitType, DungeonTrait> traits) {
		this.traits = traits;
	}
	
}
