package com.cassiohudson.aesop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.cassiohudson.aesop.CSVResource.DungeonResources;
import com.cassiohudson.aesop.CSVResource.VillainResources;
import com.cassiohudson.aesop.domain.CharacterTraitType;
import com.cassiohudson.aesop.domain.DungeonTrait;
import com.cassiohudson.aesop.domain.DungeonTraitType;
import com.cassiohudson.aesop.domain.VillainTraitType;
import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.generator.VillianTrait;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class DungeonTraitHome extends GenericDAO implements DungeonTraitService {

	private final HashMap<DungeonTraitType, List<DungeonTrait>> DATA = this.getAllData();
	
	public DungeonTraitHome(){
		super(DATA_TABLE);
	}
	
	public HashMap<DungeonTraitType, DungeonTrait> getRandomDungeonsTraits(){
		HashMap<DungeonTraitType, DungeonTrait> traits = new HashMap<DungeonTraitType, DungeonTrait>();
		traits.put(DungeonTraitType.NAME, getNewTrait(DungeonTraitType.NAME));
		traits.put(DungeonTraitType.CREATOR, getNewTrait(DungeonTraitType.CREATOR));
		traits.put(DungeonTraitType.LOCATION, getNewTrait(DungeonTraitType.LOCATION));
		traits.put(DungeonTraitType.PURPOSE, getNewTrait(DungeonTraitType.PURPOSE));
		traits.put(DungeonTraitType.HISTORY, getNewTrait(DungeonTraitType.HISTORY));
		return traits;
	}
	
	private DungeonTrait getNewTrait(DungeonTraitType type){
		DungeonTrait dt = getRandomTrait(type);
		DungeonTrait newDt = getMoreInFo(dt);
		return newDt;
	}
	
	private DungeonTrait getRandomTrait(DungeonTraitType type){
		return DATA.get(type).get(new Random().nextInt(DATA.get(type).size()));
	}
	
	private String getRandomSubTrait(DungeonTraitType type){
		return getRandomTrait(type).getBio();
	}
	
	private DungeonTrait getMoreInFo(DungeonTrait trait){
		if(trait.getTrait().equals("Humans")){
			String subTrait = Aesop.addLine(getRandomSubTrait(DungeonTraitType.NCP_CLASS)).concat(Aesop.addLine(getRandomSubTrait(DungeonTraitType.NCP_ALIGNMENT)));
			trait.setSubTrait(subTrait);
		}
		else if(trait.getTrait().equals("Cult or religious group")){
			trait.setSubTrait(getRandomSubTrait(DungeonTraitType.CULT));
		}
		return trait;
	}
	
	
	public void insertAllData(){
		HashMap<DungeonTraitType, List<DungeonTrait>> hash = new DungeonResources().getAllData();
		List<HashMap<String, String>> hashList = new ArrayList<HashMap<String,String>>();
		for(DungeonTraitType type : hash.keySet()){
			for(DungeonTrait dt : hash.get(type)){
				HashMap<String, String> row = new HashMap<String, String>();
				row.put("type", type.toString());
				row.put("weight", dt.getWeight());
				row.put("trait", dt.getTrait());
				row.put("description", dt.getDescription());
				hashList.add(row);
			}
		}
		ConnectionUtils.executeSql(this.createInsertFromHashList(hashList));
	}
	
	public HashMap<DungeonTraitType, List<DungeonTrait>> getAllData(){
		HashMap<DungeonTraitType, List<DungeonTrait>> hash = new HashMap<DungeonTraitType, List<DungeonTrait>>();
		ResultSet rs = this.getAllFromTable();
		try {
			while(rs.next()){
				DungeonTraitType type = DungeonTraitType.valueOf(rs.getString("type"));
				if(hash.containsKey(type)){
					List<DungeonTrait> list = hash.get(type);
					DungeonTrait dt = new DungeonTrait();
					dt.setWeight(rs.getString("weight"));
					dt.setType(DungeonTraitType.getDisplay(type));;
					dt.setTrait(rs.getString("trait"));
					dt.setDescription(rs.getString("description"));
					for(int i=0; i<dt.getWeightInt(); i++){
						list.add(dt);
					}
				}
				else{
					List<DungeonTrait> list = new ArrayList<DungeonTrait>();
					DungeonTrait dt = new DungeonTrait();
					dt.setWeight(rs.getString("weight"));
					dt.setTrait(rs.getString("trait"));
					dt.setType(DungeonTraitType.getDisplay(type));;
					dt.setDescription(rs.getString("description"));
					for(int i=0; i<dt.getWeightInt(); i++){
						list.add(dt);
					}
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
