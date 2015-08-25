package com.cassiohudson.aesop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cassiohudson.aesop.domain.Encounter;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class ForestEncounterHome extends GenericDAO implements ForestEncounterService{

	public ForestEncounterHome(){
		super(DATA_TABLE);
	}
	
	public List<Encounter> getAllData(){
		List<Encounter> list = new ArrayList<Encounter>();
		ResultSet rs = super.getAllFromTable();
		try {
			while(rs.next()){
				Encounter e = new Encounter(rs.getString("title"), rs.getString("description"), rs.getString("roll"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionUtils.close(rs);
		return list;
	}
	
}
