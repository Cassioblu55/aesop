package com.cassiohudson.aesop.CSVResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.domain.VillainTraitType;
import com.cassiohudson.aesop.generator.VillianTrait;

public class VillainResources extends GenericResource {
	
	private static final String PATH = "villain//"; 

	public VillainResources(){
		super(PATH);
	}
	
	public HashMap<VillainTraitType, List<VillianTrait>> getAllData(){
		HashMap<VillainTraitType, List<VillianTrait>> hash = new HashMap<VillainTraitType, List<VillianTrait>>();
		List<String> rows = new ArrayList<String>(Arrays.asList("kind", "description"));
		for(VillainTraitType type : VillainTraitType.values()){
			
			HashMap<String, List<String>> masterHash = this.getCSVRowHash(type.toString(), rows);
			List<String> kindList = masterHash.get("kind");
			List<String> descriptionList = masterHash.get("description");			

			if(kindList.size() == descriptionList.size()){
				for(int i=0; i<kindList.size(); i++){
					VillianTrait vt = new VillianTrait();
					vt.setKind(kindList.get(i));
					vt.setDescription(descriptionList.get(i));
					if(hash.containsKey(type)){
						List<VillianTrait> list = hash.get(type);
						list.add(vt);
					}
					else{
						List<VillianTrait> list = new ArrayList<VillianTrait>();
						list.add(vt);
						hash.put(type, list);
					}
				}
			}
		}
		return hash;
	}
	
}
