package com.cassiohudson.aesop.generator;

public class VillianTrait {

	private String kind;
	private String description;
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBio() {
		return this.kind.concat(", ").concat(description);
	}
	
	
	
}
