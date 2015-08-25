package com.cassiohudson.aesop.generator;

import java.util.Arrays;
import java.util.List;

public class Roll {

	private Integer numberOfDice;
	private Integer diceType;
	private Integer addAmount;
	
	public Roll(String roll){
		List<String> splitByD = Arrays.asList(roll.split("d"));
		List<String> splaitByAdd = Arrays.asList(splitByD.get(1).split("\\+"));
		this.numberOfDice = Integer.valueOf(splitByD.get(0));
		this.diceType = Integer.valueOf(splaitByAdd.get(0));
		this.addAmount = Integer.valueOf(splaitByAdd.get(1));
	}
	
	public Roll(Integer numberOfDice, Integer diceType, Integer addAmount){
		this.numberOfDice = numberOfDice;
		this.diceType = diceType;
		this.addAmount = addAmount;
	}
	
	public Integer roll(){
		Integer roll = 0;
		for(Integer i=0; i<numberOfDice; i++){
			roll += Aesop.getRandom(1, diceType);
		}
		return roll+addAmount;
	}
	
	
}
