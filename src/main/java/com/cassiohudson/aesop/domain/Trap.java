package com.cassiohudson.aesop.domain;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.generator.Position;

public class Trap {

	private String name;
	private String description;
	private Position position;
	private Integer weight;
	
	public Trap(String name, String description, Integer weight){
		this.name = name;
		this.description = description;
		this.weight = weight;
	}
	
	public Trap(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getBio() {
		String bio = new String();
		if(this.position != null){
		 bio = Aesop.addLine(name.concat(this.position.getDisplay()));}
		else{
			bio = Aesop.addLine(name);
		}
		bio = bio.concat(Aesop.addLine(description));
		return bio;
	};
	
	
	
}
