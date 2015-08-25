package com.cassiohudson.aesop.domain;


public enum SettelemntTraitType implements TraitType{
	RACE_RELATIONS, RULER_STATUS, NOTABLE_TRAITS, KNOWN_FOR, CURRENT_CALAMITY;
	
	public static String getDisplay(SettelemntTraitType t){
		switch (t) {
		case RACE_RELATIONS:
			return "Race relations";
		case RULER_STATUS:
			return "Ruler status";
		case NOTABLE_TRAITS:
			return "Notable traits";
		case KNOWN_FOR:
			return "Known for";
		case CURRENT_CALAMITY:
			return "Current calamity";
		default:
			return null;
		}
	}

}
