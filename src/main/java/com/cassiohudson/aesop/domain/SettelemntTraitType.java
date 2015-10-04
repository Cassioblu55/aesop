package com.cassiohudson.aesop.domain;


public enum SettelemntTraitType implements TraitType{
	race_relations, ruler_status, notable_traits, known_for, current_calamity, name;
	
	public static String getDisplay(SettelemntTraitType t){
		switch (t) {
		case race_relations:
			return "Race relations";
		case ruler_status:
			return "Ruler status";
		case notable_traits:
			return "Notable traits";
		case known_for:
			return "Known for";
		case current_calamity:
			return "Current calamity";
		case name:
			return "Name";
		default:
			return null;
		}
	}

}
