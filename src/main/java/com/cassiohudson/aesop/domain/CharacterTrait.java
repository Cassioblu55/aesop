package com.cassiohudson.aesop.domain;


public class CharacterTrait implements Trait{

	private CharacterTraitType type;
	private String trait;
	
	public CharacterTrait(CharacterTraitType type, String trait){
		this.setType(type);
		this.setTrait(trait);
	}

	public CharacterTraitType getType() {
		return type;
	}

	public void setType(CharacterTraitType type) {
		this.type = type;
	}

	public String getTrait() {
		return trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}
	
}
