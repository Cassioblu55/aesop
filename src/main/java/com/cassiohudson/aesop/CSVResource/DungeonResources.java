package com.cassiohudson.aesop.CSVResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.DungeonTrait;
import com.cassiohudson.aesop.domain.DungeonTraitType;
import com.cassiohudson.aesop.domain.VillainTraitType;
import com.cassiohudson.aesop.generator.VillianTrait;

public class DungeonResources extends GenericResource {
	
	private static final String PATH = "dungeon//"; 

	public DungeonResources(){
		super(PATH);
	}
	
	public HashMap<DungeonTraitType, List<DungeonTrait>> getAllData(){
		HashMap<DungeonTraitType, List<DungeonTrait>> hash = new HashMap<DungeonTraitType, List<DungeonTrait>>();
		List<String> defaultRows = new ArrayList<String>(Arrays.asList("trait", "weight"));
		List<String> purposeRows = new ArrayList<String>(Arrays.asList("trait","description", "weight"));
		for(DungeonTraitType type : DungeonTraitType.values()){
			if(type==DungeonTraitType.PURPOSE){
				HashMap<String, List<String>> masterHash = this.getCSVRowHash(type.toString(), purposeRows);
				List<String> traitList = masterHash.get("trait");
				List<String> weightList = masterHash.get("weight");
				List<String> descriptionList = masterHash.get("description");
				
				if(traitList.size() == descriptionList.size() && traitList.size() == weightList.size()){
					List<DungeonTrait> list = new ArrayList<DungeonTrait>();
					for(int i=0; i<traitList.size(); i++){
						DungeonTrait dt = new DungeonTrait();
						dt.setWeight(weightList.get(i));
						dt.setDescription(descriptionList.get(i));
						dt.setTrait(traitList.get(i));
						list.add(dt);
					}
					hash.put(type, list);
				}
			}
			else{
				HashMap<String, List<String>> masterHash = this.getCSVRowHash(type.toString(), defaultRows);
				List<String> traitList = masterHash.get("trait");
				List<String> weightList = masterHash.get("weight");
				if(traitList.size() == weightList.size()){
					List<DungeonTrait> list = new ArrayList<DungeonTrait>();
					for(int i=0; i<traitList.size(); i++){
						DungeonTrait dt = new DungeonTrait();
						dt.setWeight(weightList.get(i));
						dt.setTrait(traitList.get(i));
						list.add(dt);
					}
					hash.put(type, list);
				}
			}
		}
		return hash;
	}
	
}
