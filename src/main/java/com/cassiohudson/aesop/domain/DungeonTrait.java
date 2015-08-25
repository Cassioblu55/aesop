package com.cassiohudson.aesop.domain;

import com.cassiohudson.aesop.generator.Aesop;

public class DungeonTrait {

	private String trait;
	private String type;
	private String description;
	private String weight;
	private String subTrait;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTrait() {
		return trait;
	}
	public void setTrait(String trait) {
		this.trait = trait;
	}
	public String getDescription() {
		return (description != null) ? description : "";
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWeight() {
		return weight;
	}
	public Integer getWeightInt(){
		return Integer.parseInt(weight);
	}
	public void setWeight(String weight) {
		this.weight = weight;
	} 
	
	public String getBio(){
		String bio = new String();
		if(!this.description.equals("")){
			bio =Aesop.addLine(this.type.concat(" ").concat(trait).concat(": "));
			bio = bio.concat(Aesop.addLine(description));
		}
		else{
			bio = Aesop.addLine(this.type.concat(": ").concat(this.trait));
		}
		if(this.subTrait != null && !this.subTrait.equals("")){
			bio = bio.concat(Aesop.addLine(subTrait));
		}
		return bio;
	}
	
	public String getSubTrait() {
		return subTrait;
	}
	public void setSubTrait(String subTrait) {
		this.subTrait = subTrait;
	}
	
	
	
}
