package com.cassiohudson.aesop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cassiohudson.aesop.domain.Encounter;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class UrbanEncounterHome extends GenericDAO implements UrbanEncounterService {

	public UrbanEncounterHome(){
		super(DATA_TABLE);
	}
	
	public List<Encounter> getEncounters(){
		List<Encounter> list = new ArrayList<Encounter>();
		ResultSet rs = super.getAllFromTable();
		try {
			while(rs.next()){
				Encounter ue = new Encounter(rs.getString("title"),
						rs.getString("description"), rs.getString("roll"));
				list.add(ue);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnectionUtils.close(rs);
		return list;
	}
	
}
