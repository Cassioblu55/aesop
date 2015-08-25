package com.cassiohudson.aesop.generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.cassiohudson.aesop.CSVResource.DataSource;
import com.cassiohudson.aesop.dao.SettelementTraitHome;
import com.cassiohudson.aesop.domain.Settelement;
import com.cassiohudson.aesop.domain.SettelementTrait;
import com.cassiohudson.aesop.domain.SettelemntTraitType;
import com.cassiohudson.aesop.utils.CreateOutputFile;

public class SettelementCreate implements ActionListener{

	private static final String PATH = Aesop.ASSEST_PATH.concat("Settelements//");
	
	private final HashMap<SettelemntTraitType, List<String>> data = new SettelementTraitHome().getAllData();

	
	public Settelement getSettelement(){
		HashMap<SettelemntTraitType, String> hash = new HashMap<SettelemntTraitType, String>();
		for(SettelemntTraitType type : SettelemntTraitType.values()){
			hash.put(type, Aesop.getRandomString(data.get(type))); 
		} 
		return new Settelement(hash);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		Settelement s = this.getSettelement();
		CreateOutputFile.outPutFile(s.getBio(), PATH.concat(s.getFileName()));
	}

}
