package com.cassiohudson.aesop.generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import com.cassiohudson.aesop.dao.VillainTraitHome;
import com.cassiohudson.aesop.domain.Villain;
import com.cassiohudson.aesop.domain.VillainTraitType;
import com.cassiohudson.aesop.utils.CreateOutputFile;

public class VillianCreate implements ActionListener {

	private static final String PATH = Aesop.ASSEST_PATH.concat("Villains//");

	public static Villain createVillian(){
		HashMap<VillainTraitType, VillianTrait> traits = new VillainTraitHome().getRandomVillianTraits();
		return new Villain(traits, CharacterCreate.createCharacter());
	}
	
	public void actionPerformed(ActionEvent e) {
		Villain v = createVillian();
		CreateOutputFile.outPutFile(v.getBio(), PATH.concat(v.getFileName()));
		
	}

}
