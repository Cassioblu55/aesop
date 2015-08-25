package com.cassiohudson.aesop.generator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cassiohudson.aesop.generator.DungeonMapCreate.MapSize;

public class DungeonMapCreateTest {

	@Test
	public void dungeonMapShouldCreateDungeonMap(){
		DungeonMapCreate dmc = new DungeonMapCreate(null);
		List<List<DungeonSquare>> list = dmc.getBlankMap(MapSize.MEDIUM);
		assertEquals(10, list.size());
		for(List<DungeonSquare> row : list){
			assertEquals(10, row.size());
		}
	}
	
}
