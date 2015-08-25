package com.cassiohudson.aesop.dao;

import java.util.List;

import com.cassiohudson.aesop.domain.SettelementTrait;
import com.cassiohudson.aesop.domain.SettelemntTraitType;

public interface SettelementTraitService extends GenericDaoService{
	public List<SettelementTrait> findByType(SettelemntTraitType type);
	public SettelementTrait findById(Integer id);
	public SettelementTrait findByTrait(String trait);
	
	public static final String DATA_TABLE = "settelement_traits";
}
