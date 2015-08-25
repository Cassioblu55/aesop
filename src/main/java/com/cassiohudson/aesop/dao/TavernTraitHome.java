package com.cassiohudson.aesop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.TavenTraitType;
import com.cassiohudson.aesop.domain.TavernTrait;
import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class TavernTraitHome extends GenericDAO implements TavernTraitService {
	
	public TavernTraitHome(){
		super(DATA_TABLE);
	}
	
	public HashMap<TavenTraitType, List<String>> getAllData(){
		HashMap<TavenTraitType, List<String>> hash = new HashMap<TavenTraitType, List<String>>();
		ResultSet rs = super.getAllFromTable();
		try {
			while(rs.next()){
				TavenTraitType type = TavenTraitType.valueOf(rs.getString("type"));
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
	
	
	
	public List<TavernTrait> findByType(TavenTraitType type) {
		String sql = this.getQueryPath() + "`type` LIKE '".concat(type.toString()).concat("'");
		return getResuts(sql);
	}

	
	public TavernTrait findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public TavernTrait findByTrait(String trait) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void insertTraitByType(String type, List<String> list) {
		try {
			Connection con = new ConnectionUtils().newConnection();
			for(String trait : list){
				Statement stmt = con.createStatement();
				String sql = this.getInsertPath()+ "('"+trait+"','"+type+"')";
				
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static List<TavernTrait> getResuts(String sql){
		List<TavernTrait> list = new ArrayList<TavernTrait>();
		try {
			ResultSet rs; Connection con;
			con = new ConnectionUtils().newConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			try {
				while(rs.next()){
					TavernTrait ct = new TavernTrait(TavenTraitType.valueOf(rs.getString("type")), rs.getString("trait"));
					list.add(ct);
				}
			con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public String getInsertPath() {
		return INSERT_START.concat(DATA_TABLE).concat(INSERT_END);
	}

	
	public String getQueryPath() {
		return QUERY_START.concat(DATA_TABLE).concat(QUERY_END);
	}

}
