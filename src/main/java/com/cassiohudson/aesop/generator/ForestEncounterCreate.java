package com.cassiohudson.aesop.generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import com.cassiohudson.aesop.dao.ForestEncounterHome;
import com.cassiohudson.aesop.dao.UrbanEncounterHome;
import com.cassiohudson.aesop.domain.Encounter;
import com.cassiohudson.aesop.utils.CreateOutputFile;

public class ForestEncounterCreate implements ActionListener {

	private static final String PATH = Aesop.ASSEST_PATH.concat("ForestEncounters//");
	private final List<Encounter> data = new ForestEncounterHome().getAllData();

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Encounter ue = this.getUrbanEncounter();
		CreateOutputFile.outPutFile(ue.getBio(), PATH.concat(ue.getFileName()));

	}

	public Encounter getUrbanEncounter() {
		return data.get(new Random().nextInt(data.size()));
	}

}
