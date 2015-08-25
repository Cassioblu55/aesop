package com.cassiohudson.aesop.domain;

public class SettelementTrait {

	private SettelemntTraitType type;
	private String trait;
	
	public SettelementTrait(SettelemntTraitType type, String trait){
		this.type = type;
		this.trait = trait;
	}
	
	public SettelemntTraitType getType() {
		return type;
	}
	public void setType(SettelemntTraitType type) {
		this.type = type;
	}
	public String getTrait() {
		return trait;
	}
	public void setTrait(String trait) {
		this.trait = trait;
	}
	
	
	
}
