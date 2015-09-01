package com.cassiohudson.aesop.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.cassiohudson.aesop.domain.Dungeon;
import com.cassiohudson.aesop.generator.DungeonMapCreate.MapSize;
import com.cassiohudson.aesop.generator.DungeonSquare.SquareType;

public class DungeonMap {

	private enum Direction {
		UP, DOWN, LEFT, RIGHT
	};

	private List<List<DungeonSquare>> map;
	private Dungeon dungeon;
	private Set<Position> usedSquares = new HashSet<Position>();
	private MapSize size;
	private final HashMap<MapSize, Integer> hash = this.getSizeHashMap();
	private static final Random random = new Random();

	public DungeonMap(List<List<DungeonSquare>> map, Dungeon dungeon,
			MapSize size) {
		this.map = map;
		this.size = size;
		this.dungeon = dungeon;
		generateMap();
	}

	public void generateMap() {
		Integer size = this.map.size();
		// Set Start
		DungeonSquare start = this.getSquare(new Random().nextInt(size), 0);
		start.setType(SquareType.START);
		this.usedSquares.add(start.getPosition());
		this.buildBranch(start, Direction.DOWN);
		//Will not try to make more then 1000 attempts make a branch
		Integer count =new Integer(0);
		while (this.usedSquares.size() < hash.get(this.size) && count<1000) {
			DungeonSquare s = getRandomActiveSquare();
			this.buildBranch(s, getRandomDirection());
			count++;
		}

	}

	private DungeonSquare getRandomActiveSquare() {
		List<Position> activeList = new ArrayList<Position>(this.usedSquares);
		return this.getSquare(activeList.get(random.nextInt(this.usedSquares
				.size())));
	}

	private void buildBranch(DungeonSquare square, Direction move) {
		Integer size = new Random().nextInt(3) + 1;
		for (int i = 0; i < size; i++) {
			if (square != null) {
				square = this.getSquare(square.getPosition(), move);
				if (square != null && findVaildBranch(square, move)
						&& this.usedSquares.contains(square.getPosition()) == false) {
					square.setType(SquareType.WALKWAY);
					this.usedSquares.add(square.getPosition());
				}
			}
		}
	}

	private Boolean inList(DungeonSquare s){
		if(s ==null){return false;}
		return this.usedSquares.contains(s.getPosition());
	}
	
	private Boolean findVaildBranch(DungeonSquare square, Direction move) {		
		if(move.equals(Direction.DOWN)){
			//Look down right and down left
			DungeonSquare d1 = getSquare(square.getPosition(), Direction.DOWN, Direction.RIGHT);
			DungeonSquare d2 = getSquare(square.getPosition(), Direction.DOWN, Direction.LEFT);
			if((inList(d1)) || inList(d2)){return false;}
			else{return true;}
		}
		else if(move.equals(Direction.UP)){
			//Look up left and up right
			DungeonSquare d1 = getSquare(square.getPosition(), Direction.UP, Direction.RIGHT);
			DungeonSquare d2 = getSquare(square.getPosition(), Direction.UP, Direction.LEFT);
			if(inList(d1) || inList(d2)){return false;}
			else{return true;}
		}	
		else if(move.equals(Direction.LEFT)){
			//Look down left and up left
			DungeonSquare d1 = getSquare(square.getPosition(), Direction.DOWN, Direction.LEFT);
			DungeonSquare d2 = getSquare(square.getPosition(), Direction.UP, Direction.LEFT);
			if(inList(d1) || inList(d2)){return false;}
			else{return true;}
		}
		else{
			//Look down right and up right
			DungeonSquare d1 = getSquare(square.getPosition(), Direction.DOWN, Direction.RIGHT);
			DungeonSquare d2 = getSquare(square.getPosition(), Direction.UP, Direction.RIGHT);
			if(inList(d1) || inList(d2)){return false;}
			else{return true;}
		}	
	}

	
	private Direction getRandomDirection() {
		final List<Direction> list = Collections.unmodifiableList(Arrays
				.asList(Direction.values()));
		return list.get(new Random().nextInt(list.size() - 1));
	}

	private DungeonSquare getSquare(Position pos) {
		return this.map.get(pos.getY()).get(pos.getX());
	}
	
	private DungeonSquare getSquare(Position pos, Direction moveOne, Direction moveTwo) {
		DungeonSquare s = this.getSquare(pos, moveOne); DungeonSquare s2= null;
		if(s != null){
			s2 = this.getSquare(s.getPosition(), moveTwo);
		}
		return (s2 != null) ? s2 :null;
	}

	private DungeonSquare getSquare(Position pos, Direction move) {
		if (move.equals(Direction.UP) && pos.getY() != 0) {
			return this.map.get(pos.getY() - 1).get(pos.getX());
		} else if (move.equals(Direction.DOWN)
				&& this.map.size() > pos.getY() + 1) {
			return this.map.get(pos.getY() + 1).get(pos.getX());
		} else if (move.equals(Direction.LEFT) && pos.getX() != 0) {
			return this.map.get(pos.getY()).get(pos.getX() - 1);
		} else if (move.equals(Direction.RIGHT)
				&& this.map.size() > pos.getX() + 1) {
			return this.map.get(pos.getY()).get(pos.getX() + 1);
		}
		return null;
	}

	private DungeonSquare getSquare(Integer x, Integer y) {
		return this.map.get(y).get(x);
	}

	public String mapDisplay() {
		String display = new String();
		for (List<DungeonSquare> row : map) {
			String rowDisplay = new String();
			for (DungeonSquare square : row) {
				rowDisplay = rowDisplay.concat(String.valueOf(square
						.getDisplay()));
			}
			display = display.concat(Aesop.nextLine(rowDisplay));
		}
		return display;
	}

	private HashMap<MapSize, Integer> getSizeHashMap() {
		HashMap<MapSize, Integer> hash = new HashMap<DungeonMapCreate.MapSize, Integer>();
		hash.put(MapSize.LARGE, 50);
		hash.put(MapSize.MEDIUM, 30);
		hash.put(MapSize.SMALL, 15);
		return hash;
	}

	public String getBio() {
		String bio = Aesop.nextLine(this.dungeon.getBio());
		bio = bio.concat(this.addMapDispaly());
		return bio;
	}

	private String addMapDispaly() {
		String bio = Aesop.nextLine("Map:");
		bio = bio.concat(Aesop.nextLine(mapDisplay()));
		return bio;
	}
}
