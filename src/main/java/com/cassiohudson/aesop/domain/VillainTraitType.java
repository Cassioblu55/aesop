package com.cassiohudson.aesop.domain;

public enum VillainTraitType {
	WEAKNESS, METHODS, SCHEME;
	
	public static String getDisplay(VillainTraitType type){
		switch (type) {
		case WEAKNESS:
			return "Weakness";
		case METHODS:
			return "Methods";
		case SCHEME:
			return "Scheme";
		default:
			return null;
		}
	}
	
}
