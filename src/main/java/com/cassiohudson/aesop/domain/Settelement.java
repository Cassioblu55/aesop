package com.cassiohudson.aesop.domain;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cassiohudson.aesop.CSVResource.ReadFromCSV;
import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.generator.Assest;

public class Settelement implements Assest {

	private static final String PATH = "settelements//";
	
	private HashMap<SettelemntTraitType, String> hash;
	private List<SettelementTrait> list;
	private String name;
	
	public Settelement(HashMap<SettelemntTraitType, String> hash) {
		try {
			this.name = ReadFromCSV.getRandom(PATH.concat("settelementNames"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.hash = hash;
	}
	
	public Settelement(String name, List<SettelementTrait> list){
		this.name = name;
		this.list = list;
	}

	
	public String getFileName(){
		String fixedName = this.name.replace(" ", "_");
		return fixedName.concat(Aesop.TXT_EXT);
	}
	
	public String getBio(){
		String s  = Aesop.addLine(StringUtils.capitalize(name));
		for(SettelemntTraitType st : hash.keySet()){
			String traitString = SettelemntTraitType.getDisplay(st).concat(": ").concat(hash.get(st));
			s = s.concat(Aesop.addLine(traitString));
		}
		return s;
	}
	
	public List<SettelementTrait> getList() {
		return list;
	}

	public void setList(List<SettelementTrait> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
