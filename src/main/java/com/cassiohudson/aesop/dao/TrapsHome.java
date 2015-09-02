package com.cassiohudson.aesop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cassiohudson.aesop.domain.Trap;

public class TrapsHome extends GenericDAO implements TrapsService{

	private enum Columns{id,name,description,weight};
	
	public TrapsHome() {
		super(DATA_TABLE);
	}

	public List<Trap> getTraps(){
		ResultSet rs = this.getAllFromTable();
		List<Trap> list = new ArrayList<Trap>();
		try {
			while(rs.next()){
				Trap t = new Trap();
				for(Columns c: Columns.values()){
					if(c.toString().equals("name")){
						t.setName(rs.getString(c.toString()));
					}
					else if(c.toString().equals("description")){
						t.setDescription(rs.getString(c.toString()));
					}
					else if(c.toString().equals("weight")){
						t.setWeight(rs.getInt(c.toString()));
					}
				}
				
				for(Integer i=0; i<t.getWeight(); i++){
					list.add(t);
				}
				}
			}catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	
	
}
