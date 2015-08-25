package com.cassiohudson.aesop.dao;

import java.util.List;

import com.cassiohudson.aesop.domain.CharacterExperience;

public interface CharacterExperienceService {

	
	public final String DATA_TABLE = "character_experience";
	public List<CharacterExperience> getAllCharacters();
	public void addExperience(CharacterExperience ce, Integer ex);
}
