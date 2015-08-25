package com.cassiohudson.aesop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.CharacterTraitType;
import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class CharacterTraitHome extends GenericDAO implements CharacterTraitService{

	private final HashMap<CharacterTraitType, List<String>> data = this.getAllData();
	
	public CharacterTraitHome(){
		super(DATA_TABLE);
	}
	
	public HashMap<CharacterTraitType, String> getRandomCharacterTraits(){
		HashMap<CharacterTraitType, String> hash = new HashMap<CharacterTraitType, String>();
		for(CharacterTraitType t : CharacterTraitType.values()){
			String trait = Aesop.getRandomString(data.get(t));
			hash.put(t, trait);
		}
		return hash;
	}
	
	private HashMap<CharacterTraitType, List<String>> getAllData(){
		HashMap<CharacterTraitType, List<String>> hash = new HashMap<CharacterTraitType, List<String>>();
		ResultSet rs = super.getAllFromTable();
		try {
			while(rs.next()){
				CharacterTraitType type = CharacterTraitType.valueOf(rs.getString("type"));
				if(hash.containsKey(type)){
					List<String> list = hash.get(type);
					list.add(rs.getString("trait"));
				}
				else{
					List<String> list = new ArrayList<String>();
					list.add(rs.getString("trait"));
					hash.put(type, list);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionUtils.close(rs);
		return hash;
	}
}
