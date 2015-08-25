package com.cassiohudson.aesop.domain;


public enum CharacterTraitType implements TraitType{
	ABILITY, TALENT, IDEAL, BOND, FLAW, MANNERISM, APPEARANCE, INTERACTION;

	public static String getDisplay(CharacterTraitType type) {
		switch (type) {
		case ABILITY:
			return "Ability";
		case TALENT:
			return "Talent";
		case IDEAL: 
			return "Ideals";
		case BOND:
			return "Bond";
		case FLAW:
			return "Flaw";
		case MANNERISM:
			return "Mannerism";
		case APPEARANCE:
			return "Appearance";
		case INTERACTION:
			return "Interaction trait";
		default:
			return null;
		}
	}
}
