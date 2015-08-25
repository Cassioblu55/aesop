package com.cassiohudson.aesop.userInterface;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import com.cassiohudson.aesop.dao.InsertData;
import com.cassiohudson.aesop.generator.CharacterCreate;
import com.cassiohudson.aesop.generator.DungeonCreate;
import com.cassiohudson.aesop.generator.ForestEncounterCreate;
import com.cassiohudson.aesop.generator.SettelementCreate;
import com.cassiohudson.aesop.generator.TavenCreate;
import com.cassiohudson.aesop.generator.UrbanEncounterCreate;
import com.cassiohudson.aesop.generator.VillianCreate;

public class ButtonGenerator {
	
	private static JButton getSettelementButton(){
		JButton button = new JButton("Create Settelement");
		button.addActionListener(new SettelementCreate());
		return button;
	}
	
	private static JButton getDungeonButton(){
		JButton button = new JButton("Create Dungeon");
		button.addActionListener(new DungeonCreate());
		return button;
	}

	private static JButton getCharacterButton() {
		JButton button = new JButton("Create Character");
		button.addActionListener(new CharacterCreate());
		return button;
	}

	private static JButton getTavernButton() {
		JButton button = new JButton("Create Taven");
		button.addActionListener(new TavenCreate());
		return button;
	}
	
	private static JButton getUrbanEncountersButton(){
		JButton button = new JButton("Create Urban Encounter");
		button.addActionListener(new UrbanEncounterCreate());
		return button;
	}
	
	private static JButton getForestEncountersButton(){
		JButton button = new JButton("Create Forest Encounter");
		button.addActionListener(new ForestEncounterCreate());
		return button;
	}
	
	private static JButton getVillianButton(){
		JButton button = new JButton("Create Villian");
		button.addActionListener(new VillianCreate());
		return button;
	}
	
	private static JButton getDataInsertButton(){
		JButton button = new JButton("Insert Data");
		button.addActionListener(new InsertData());
		return button;
	}
	
	public static List<JButton> getAllButtons(){
		List<JButton> list = new ArrayList<JButton>();
		list.add(getSettelementButton());
		list.add(getCharacterButton());
		list.add(getTavernButton());
		list.add(getVillianButton());
		list.add(getForestEncountersButton());
		list.add(getUrbanEncountersButton());
		list.add(getDungeonButton());
		list.add(getDataInsertButton());
		return list;
	}
	
}
