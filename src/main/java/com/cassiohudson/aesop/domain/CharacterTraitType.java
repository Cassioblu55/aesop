package com.cassiohudson.aesop.domain;


public enum CharacterTraitType implements TraitType{
	ability, talent, ideal, bond, flaw, mannerism, appearance, interaction, last_name,male_name,female_name;

	public static String getDisplay(CharacterTraitType type) {
		switch (type) {
		case ability:
			return "Ability";
		case talent:
			return "Talent";
		case ideal: 
			return "Ideals";
		case bond:
			return "Bond";
		case flaw:
			return "Flaw";
		case mannerism:
			return "Mannerism";
		case appearance:
			return "Appearance";
		case interaction:
			return "Interaction trait";
		default:
			return null;
		}
	}
}
