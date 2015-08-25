package com.cassiohudson.aesop.userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import com.cassiohudson.aesop.dao.DungeonTraitHome;
import com.cassiohudson.aesop.dao.InsertAllCSVData;
import com.cassiohudson.aesop.dao.InsertData;
import com.cassiohudson.aesop.dao.VillainTraitHome;
import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.utils.FrameUtils;

public class InsertButtonGenerator {

	public static List<JButton> getAllButtons() {
		List<JButton> list = new ArrayList<JButton>();
		list.add(getCharacterTraitInsert());
		list.add(getTavernTraitInsert());
		list.add(getSettelmentTraitInsert());
		list.add(goToMenu());
		list.add(getVillianTraitInsert());
		list.add(getDungeonTraitInsert());
		return list;
	}
	
	private static JButton getCharacterTraitInsert(){
		JButton button = new JButton("Insert Character Data");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//InsertAllCSVData.insertChracterTraits();				
			}
		});
		return button;
	}
	
	private static JButton getTavernTraitInsert(){
		JButton button = new JButton("Insert Tavern Data");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InsertAllCSVData.insertTavernTraits();				
			}
		});
		return button;
	}
	
	private static JButton getSettelmentTraitInsert(){
		JButton button = new JButton("Insert Settelment Data");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InsertAllCSVData.insertSettelmentTraits();				
			}
		});
		return button;
	}
	
	private static JButton getDungeonTraitInsert(){
		JButton button = new JButton("Insert Dungeon Data");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DungeonTraitHome().insertAllData();				
			}
		});
		return button;
	}
	
	private static JButton getVillianTraitInsert(){
		JButton button = new JButton("Insert Villian Data");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VillainTraitHome().insertAllData();;				
			}
		});
		return button;
	}
	
	
	private static JButton goToMenu(){
		JButton button = new JButton("Main Menu");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Aesop.MAIN_MENU.setVisible(true);
				InsertData.INSERT_MENU.setVisible(false);
			}
		});
		return button;
	}

}
