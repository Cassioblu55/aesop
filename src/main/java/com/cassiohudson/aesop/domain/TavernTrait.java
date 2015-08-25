package com.cassiohudson.aesop.domain;


public class TavernTrait implements Trait{

	private TavenTraitType type;
	private String trait;
	
	public TavernTrait(TavenTraitType type, String trait){
		this.type = type;
		this.trait = trait;
	}

	public TavenTraitType getType() {
		return type;
	}

	public void setType(TavenTraitType type) {
		this.type = type;
	}

	public String getTrait() {
		return trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}	
	
}
