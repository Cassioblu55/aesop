package com.cassiohudson.aesop.generator;

import java.util.Random;

public class CharacterStats {
	
	private Name name;
	private Gender gender;
	private Integer age;
	private Integer height;
	private Integer weight;
	
	public CharacterStats(){
		this.gender = (new Gender((new Random().nextInt(2) == 0) ? GenderType.M : GenderType.F));
		this.name = new Name(this.gender);
		this.weight = this.findWeight();
		this.height = this.findHeight();
		this.age = this.findAge();
	}
	
	public CharacterStats(Name name, Gender g, Integer age, Integer height, Integer weight){
		this.gender = g;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.name = name;
	}
	
	public Integer findAge(){
		Integer age = Aesop.getNormalRandom(7d, 30); Integer min = 16; 
		return (age < min) ? min : age;
	}
	
	public String getHeight(){
		String feet = new Integer((int)Math.floor(new Double(this.height)/12.0)).toString();
		String inches = new Integer((int)Math.floor(new Double(this.height)%12.0)).toString();
		return feet.concat("\' ").concat(inches).concat("\"");
	}
	
	private Integer findWeight(){
		Integer average = (this.gender.isMale()) ? 160 : 130;
		Double sd =  (this.gender.isMale()) ? 29d : 20d;
		return Aesop.getNormalRandom(sd, average);
	}
	
	private Integer findHeight(){
		Integer average = (this.gender.isMale()) ? 67 : 58;
		Double sd =  (this.gender.isMale()) ? 2.9d : 2.7d;
		return Aesop.getNormalRandom(sd, average);
	}

	public Integer getAge() {
		return age;
	}
	
	public String getWeight(){
		return this.weight.toString().concat("lbs");
	}

	public Name getName() {
		return name;
	}

	public Gender getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	public String getBio() {
		String s = Aesop.addLine("Gender: ".concat(this.gender.getGender()));
		String s1 =Aesop.addLine("Height: ".concat(getHeight()).concat(" ").concat("Weight: ").concat(getWeight()));
		String s2 = Aesop.addLine(("Age: ").concat(this.age.toString()));
		return s.concat(s1).concat(s2);
	}

	
}
