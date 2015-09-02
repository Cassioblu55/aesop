package com.cassiohudson.aesop.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Position {

	public static final List<String> abcs = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
	private Integer x;
	private Integer y;
	
	public Position(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
 
	public String getDisplay() {
		return "(".concat(this.x.toString()).concat(",").concat(this.getYDispaly()).concat(")");
	}

	private String getYDispaly() {
		return abcs.get(this.y);
	}
	
	
	
}
