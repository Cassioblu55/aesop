package com.cassiohudson.aesop.generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.cassiohudson.aesop.CSVResource.DataSource;
import com.cassiohudson.aesop.dao.TavernTraitHome;
import com.cassiohudson.aesop.domain.Character;
import com.cassiohudson.aesop.domain.TavenTraitType;
import com.cassiohudson.aesop.domain.Tavern;
import com.cassiohudson.aesop.domain.TavernTrait;
import com.cassiohudson.aesop.utils.CreateOutputFile;

public class TavenCreate implements ActionListener{

	private static final String PATH = Aesop.ASSEST_PATH.concat("Taverns//");
	
	public static final HashMap<TavenTraitType, List<String>> data = new TavernTraitHome().getAllData();

	public Tavern createTavern(){
		HashMap<TavenTraitType, String> hash = new HashMap<TavenTraitType, String>();
		for(TavenTraitType type : TavenTraitType.values()){
			hash.put(type, Aesop.getRandomString( data.get(type)));
		}
		return new Tavern(hash);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Tavern tavern = createTavern();
		String bio = tavern.getBio();
		bio = bio.concat(Aesop.addBlankLine(1));
		Character c = CharacterCreate.createCharacter();
		bio = bio.concat(Aesop.addLine("Tavern Shopkeep:")).concat(c.getBio());
		bio = bio.concat(Aesop.addBlankLine(1));
		CreateOutputFile.outPutFile(bio, PATH.concat(tavern.getFileName()));
	}
	
}
