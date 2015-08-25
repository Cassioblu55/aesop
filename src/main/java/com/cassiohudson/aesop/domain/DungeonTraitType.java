package com.cassiohudson.aesop.domain;

public enum DungeonTraitType {
	LOCATION,CREATOR,CULT,NCP_ALIGNMENT,NCP_CLASS,HISTORY,PURPOSE,NAME;

	public static String getDisplay(DungeonTraitType type) {
		switch (type) {
		case LOCATION:
			return "Location";
		case CREATOR:
			return "Creator";
		case CULT:
			return "Cult";
		case NCP_ALIGNMENT:
			return "Aligenment";
		case NCP_CLASS:
			return "Class";
		case PURPOSE:
			return "Purpose";
		case NAME:
			return "Name";
		case HISTORY:
			return "History";
		default:
			break;
		}
		return "";
	}
}
