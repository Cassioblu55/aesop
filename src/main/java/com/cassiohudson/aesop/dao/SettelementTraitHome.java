package com.cassiohudson.aesop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.SettelementTrait;
import com.cassiohudson.aesop.domain.SettelemntTraitType;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class SettelementTraitHome extends GenericDAO implements SettelementTraitService {
	
	public SettelementTraitHome(){
		super(DATA_TABLE);
	}
	
	public HashMap<SettelemntTraitType, List<String>> getAllData(){
		HashMap<SettelemntTraitType, List<String>> hash = new HashMap<SettelemntTraitType, List<String>>();
		ResultSet rs = super.getAllFromTable();
		try {
			while(rs.next()){
				SettelemntTraitType type = SettelemntTraitType.valueOf(rs.getString("type"));
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
	
	@Override
	public String getQueryPath() {
		return QUERY_START.concat(DATA_TABLE).concat(QUERY_END);
	}
	
	@Override
	public String getInsertPath() {
		return INSERT_START.concat(DATA_TABLE).concat(INSERT_END);
	}
	
	
	@Override
	public List<SettelementTrait> findByType(SettelemntTraitType type) {
		String sql = this.getQueryPath() + "`type` LIKE '".concat(type.toString()).concat("'");
		return getResuts(sql);
	}
	
	public void insertTraitByType(String type, List<String> list){
		try {
			Connection con = ConnectionUtils.newConnection();
			for(String trait : list){
				Statement stmt = con.createStatement();
				String sql = this.getInsertPath()+ "('"+trait+"','"+type+"')";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SettelementTrait findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SettelementTrait findByTrait(String trait) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static List<SettelementTrait> getResuts(String sql){
		List<SettelementTrait> list = new ArrayList<SettelementTrait>();
		try {
			ResultSet rs; Connection con;
			con = ConnectionUtils.newConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			try {
				while(rs.next()){
					SettelementTrait ct = new SettelementTrait(SettelemntTraitType.valueOf(rs.getString("type")),
							rs.getString("trait"));
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

	

}
