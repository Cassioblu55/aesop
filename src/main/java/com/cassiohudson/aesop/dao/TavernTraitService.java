package com.cassiohudson.aesop.dao;

import java.util.List;

import com.cassiohudson.aesop.domain.TavenTraitType;
import com.cassiohudson.aesop.domain.TavernTrait;

public interface TavernTraitService extends GenericDaoService{

	public List<TavernTrait> findByType(TavenTraitType type);
	public TavernTrait findById(Integer id);
	public TavernTrait findByTrait(String trait);
	
	public void insertTraitByType(String type, List<String> list);
	
	public final static String DATA_TABLE = "tavern_traits";
}
