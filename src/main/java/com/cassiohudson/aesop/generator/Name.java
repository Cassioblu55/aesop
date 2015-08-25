package com.cassiohudson.aesop.generator;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.cassiohudson.aesop.CSVResource.ReadFromCSV;

public class Name {

	private static final String PATH = "characters//"; 

	private String firstName;
	private String lastName;
	private Gender gender;
	
	public Name(Gender gender) {
		this.gender = gender;
		String middle = (this.gender.isMale()) ? "maleFirstNames" : "femaleFirstNames";
		try {
			this.setFirstName(ReadFromCSV.getRandom(PATH.concat(middle)));
			this.setLastName(ReadFromCSV.getRandom(PATH.concat("lastNames")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Name(String firstName, String lastName){
		this.setLastName(lastName); 
		this.setFirstName(firstName);
	}
	
	public String getFileName(){
		return firstName.concat("_").concat(lastName).concat(Aesop.TXT_EXT);
	}
	
	public String getFullName(){
		return this.firstName.concat(" ").concat(lastName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getNameBio() {
		return Aesop.addLine(StringUtils.capitalize(this.getFullName()));
	}

}
