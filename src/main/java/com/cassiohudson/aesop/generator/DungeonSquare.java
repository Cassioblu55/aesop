package com.cassiohudson.aesop.generator;

public class DungeonSquare {

	private SquareType type;
	
	private Position position;

	public enum SquareType {START, WALKWAY}
	
	
	public SquareType getType() {
		return type;
	}

	public void setType(SquareType type) {
		this.type = type;
	}

	public char getDisplay() {
		if(this.type != null){
			if(this.type.equals(SquareType.START)){
				return 's';
				}
			
			if(this.type.equals(SquareType.WALKWAY)){
				return 'w';
			}
		}
			return 'x';
		}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
