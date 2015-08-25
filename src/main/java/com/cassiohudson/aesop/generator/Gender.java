package com.cassiohudson.aesop.generator;

import org.apache.commons.lang3.StringUtils;

public class Gender {

	private GenderType gender;
	
	private static final String MALE = "male";
	private static final String FEMALE = "female";
	
	private static final String PRNOUN_MALE = "he";
	private static final String PRNOUN_FEMALE = "she";
	
	private static final String PRNOUN_MALE_ALT = "his";
	private static final String PRNOUN_FEMALE_ALT = "her";

	public Gender(GenderType gender){
		this.gender = gender;
	}
	
	public String getGender(){
		return StringUtils.capitalize((this.gender.equals(GenderType.M)) ? MALE : FEMALE);
	}
	
	public String getPronoun(){
		return (this.gender.equals(GenderType.M)) ? PRNOUN_MALE : PRNOUN_FEMALE;
	}
	
	public String genderedPronounAlt(){
		return (this.gender.equals(GenderType.M)) ? PRNOUN_MALE_ALT : PRNOUN_FEMALE_ALT;
	}

	public Boolean isMale() {
		return this.gender.equals(GenderType.M);
	}
	
}
