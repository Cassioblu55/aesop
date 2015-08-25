package com.cassiohudson.aesop.domain;

public class CharacterExperience {

	private String name;
	private Integer experience;
	
	public CharacterExperience(String name, Integer experience){
		this.name = name;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	
}
