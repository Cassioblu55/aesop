package com.cassiohudson.aesop.domain;

import java.util.Arrays;
import java.util.List;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.generator.Roll;

public class Encounter{

	private String title;
	private String description;
	private String roll;
	
	public Encounter(String title, String description, String roll){
		this.title = title;
		this.description = description;
		this.roll = roll;
	}
	
	public String getBio(){
		String bio = Aesop.addLine(this.title);
		String description = this.description;
		if(this.roll != ""){
			List<String> rollList = Arrays.asList(this.roll.split(","));
			for(String roll : rollList){
				Integer rollResult = new Roll(roll).roll();
				description = description.replace(roll, rollResult.toString());
			}
		}
		bio = bio.concat(Aesop.addLine(description));
		
		return bio;
	}
	
	public String getFileName(){
		return this.title.replace(" ", "_");
	}
	
}
