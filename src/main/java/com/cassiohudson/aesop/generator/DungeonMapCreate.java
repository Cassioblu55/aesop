package com.cassiohudson.aesop.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cassiohudson.aesop.domain.Dungeon;
import com.cassiohudson.aesop.domain.DungeonTraitType;

public class DungeonMapCreate {

	private Dungeon dungeon;
	
	public enum  MapSize {LARGE, MEDIUM, SMALL};

	public DungeonMapCreate(Dungeon dungeon){
		this.dungeon = dungeon;
	}
	
	public List<List<DungeonSquare>> getBlankMap(MapSize size){
		List<List<DungeonSquare>> masterList = new ArrayList<List<DungeonSquare>>();
		for(Integer y=0; y<this.getSize(size); y++){
			List<DungeonSquare> row = new ArrayList<DungeonSquare>();
			for(Integer x=0; x<this.getSize(size); x++){
				DungeonSquare square = new DungeonSquare();
				square.setPosition(new Position(x, y));
				row.add(square);
			}
			masterList.add(row);
		}
		return masterList;
	}
	
	private MapSize findSize(){
		String purpose = this.dungeon.getTraits().get(DungeonTraitType.PURPOSE).getTrait();
		if(purpose.equals("Maze") || purpose.equals("Mine") || purpose.equals("Stronghold")){
			return (new Random().nextInt(2) == 1) ? MapSize.MEDIUM : MapSize.LARGE;
		}
		else{
			return (new Random().nextInt(2) == 1) ? MapSize.SMALL : MapSize.MEDIUM;
		}
		
	}
	
	private Integer getSize(MapSize size){
		switch (size) {
		case LARGE:
			return 12;
		case MEDIUM:
			return 8;
		case SMALL:
			return 6;
		default:
			return null;
		}
	}

	public DungeonMap getMap() {
		MapSize size = findSize();
		List<List<DungeonSquare>> map = this.getBlankMap(size);	
		return new DungeonMap(map, dungeon, size);
	}
	
	
	
	
	
}
