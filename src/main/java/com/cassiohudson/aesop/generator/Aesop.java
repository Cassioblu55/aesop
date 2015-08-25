package com.cassiohudson.aesop.generator;

import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.cassiohudson.aesop.userInterface.CharacterExperienceFrame;
import com.cassiohudson.aesop.utils.FrameUtils;

public class Aesop {
		
	public static final String RESOURCE_PATH = "src//main//resources//";
	public static final String ASSEST_PATH ="assets//Generated Assests//"; 
	public static final String TXT_EXT = ".txt";
	public static final String CSV_EXT = ".csv";
	
	public static final String DATABASE = "cassio_aesop";
	
	public static final Integer HEIGHT = 100;
	public static final Integer WIDTH = 500;
	
	public static final JFrame MAIN_MENU = FrameUtils.getMainFrame();
	public static JFrame EXPERIENCE_MENU = CharacterExperienceFrame.getFrame();
			
	public static void main(String[] args) {
		//Create and set up the window.
		EXPERIENCE_MENU.setVisible(true);
		MAIN_MENU.setVisible(true);	
		
		DungeonMap map= new CreateDungeonMap(new DungeonCreate().getDungeon()).getMap();
		map.mapDisplay();
	}

	public static String addLine(String line){
		return line.concat("\n\n");
	}
	
	public static String addBlankLine(Integer n){
		String s = "";
		for(int i = 0; i<n; i++){
			s = s.concat("\n");
		}
		return s;
	}
	
	public static String getRandomString(List<String> list){
		return list.get(new Random().nextInt((list.size())));
	}

	public static Integer getNormalRandom(Double sd, Integer average){
		return new Integer((int) (new Random().nextGaussian()*sd)+average);
	}
	
	//Returns inclusive random number
	public static Integer getRandom(Integer min, Integer max){
		
		return new Random().nextInt((max - min) + 1)+min;
	}
	
}
