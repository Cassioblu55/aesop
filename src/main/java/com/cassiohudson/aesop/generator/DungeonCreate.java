package com.cassiohudson.aesop.generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cassiohudson.aesop.dao.DungeonTraitHome;
import com.cassiohudson.aesop.domain.Dungeon;
import com.cassiohudson.aesop.utils.CreateOutputFile;

public class DungeonCreate implements ActionListener {

	private static final String PATH = Aesop.ASSEST_PATH.concat("Dungeons//");
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Dungeon d = this.getDungeon();
		CreateOutputFile.outPutFile(d.getBio(), PATH.concat(d.getFileName()));
	}

	public Dungeon getDungeon() {
		return new Dungeon(new DungeonTraitHome().getRandomDungeonsTraits());
	}

}
