package com.cassiohudson.aesop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.cassiohudson.aesop.CSVResource.VillainResources;
import com.cassiohudson.aesop.domain.CharacterTraitType;
import com.cassiohudson.aesop.domain.VillainTraitType;
import com.cassiohudson.aesop.generator.VillianTrait;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class VillainTraitHome extends GenericDAO implements VillianTraitService {

	private final HashMap<VillainTraitType, List<VillianTrait>> DATA = this.getAllData();
	
	public VillainTraitHome(){
		super(DATA_TABLE);
	}
	
	public HashMap<VillainTraitType, VillianTrait> getRandomVillianTraits(){
		HashMap<VillainTraitType, VillianTrait> traits = new HashMap<VillainTraitType, VillianTrait>();
		for(VillainTraitType type : DATA.keySet()){
			traits.put(type, DATA.get(type).get(new Random().nextInt(DATA.get(type).size())));
		}
		return traits;
	}
	
	public void insertAllData(){
		HashMap<VillainTraitType, List<VillianTrait>> hash = new VillainResources().getAllData();
		List<HashMap<String, String>> hashList = new ArrayList<HashMap<String,String>>();
		for(VillainTraitType type : hash.keySet()){
			for(VillianTrait vt : hash.get(type)){
				HashMap<String, String> row = new HashMap<String, String>();
				row.put("type", type.toString());
				row.put("kind", vt.getKind());
				row.put("description", vt.getDescription());
				hashList.add(row);
			}
		}
		ConnectionUtils.executeSql(this.createInsertFromHashList(hashList));
	}
	
	public HashMap<VillainTraitType, List<VillianTrait>> getAllData(){
		HashMap<VillainTraitType, List<VillianTrait>> hash = new HashMap<VillainTraitType, List<VillianTrait>>();
		ResultSet rs = this.getAllFromTable();
		try {
			while(rs.next()){
				VillainTraitType type = VillainTraitType.valueOf(rs.getString("type"));
				if(hash.containsKey(type)){
					List<VillianTrait> list = hash.get(type);
					VillianTrait vt = new VillianTrait();
					vt.setKind(rs.getString("kind"));
					vt.setDescription(rs.getString("description"));
					list.add(vt);
				}
				else{
					List<VillianTrait> list = new ArrayList<VillianTrait>();
					VillianTrait vt = new VillianTrait();
					vt.setKind(rs.getString("kind"));
					vt.setDescription(rs.getString("description"));
					list.add(vt);
					hash.put(type,list);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionUtils.close(rs);
		return hash;
	}
	
	
}
