package com.cassiohudson.aesop.generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.cassiohudson.aesop.CSVResource.DataSource;
import com.cassiohudson.aesop.dao.CharacterTraitHome;
import com.cassiohudson.aesop.domain.Character;
import com.cassiohudson.aesop.domain.CharacterTrait;
import com.cassiohudson.aesop.domain.CharacterTraitType;
import com.cassiohudson.aesop.utils.CreateOutputFile;

public class CharacterCreate implements ActionListener{
	
	private static final String PATH = Aesop.ASSEST_PATH.concat("Characters//");
	
	public static Character createCharacter(){	
		HashMap<CharacterTraitType, String> hash = new CharacterTraitHome().getRandomCharacterTraits();
		return new Character(new CharacterStats(), hash);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Character c = createCharacter();
		CreateOutputFile.outPutFile(c.getBio(), PATH.concat(c.getName().getFileName()));
	}

	
}
