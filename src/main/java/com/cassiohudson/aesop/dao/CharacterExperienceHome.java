package com.cassiohudson.aesop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cassiohudson.aesop.domain.CharacterExperience;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class CharacterExperienceHome  extends GenericDAO implements CharacterExperienceService {

	public CharacterExperienceHome(){
		super(DATA_TABLE);
	}	
	
	
	public List<CharacterExperience> getAllCharacters() {
		ResultSet rs = ConnectionUtils.getResults(this.getAllQuery());
		List<CharacterExperience> list = new ArrayList<CharacterExperience>();
		try {
			while(rs.next()){
				CharacterExperience cs = new CharacterExperience(rs.getString("name"), rs.getInt("experience"));
				list.add(cs);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	public void addExperience(CharacterExperience ce, Integer ex) {
		Integer newXP = ce.getExperience()+ex;
		String sql = "UPDATE ".concat(isq(DATA_TABLE)).concat(" SET ")
				.concat(this.getEqualsString("experience", newXP.toString()))
				.concat(" WHERE ")
				.concat(this.getEqualsString("name", ce.getName()));		
		ConnectionUtils.executeSql(sql);
		
	}

}
