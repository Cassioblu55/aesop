package com.cassiohudson.aesop.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.userInterface.InsertButtonGenerator;
import com.cassiohudson.aesop.utils.FrameUtils;

public class InsertData implements ActionListener{
	
	public static final JFrame INSERT_MENU = FrameUtils.getButtonFrame("Data Insert", InsertButtonGenerator.getAllButtons());
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Aesop.MAIN_MENU.setVisible(false);
		
		INSERT_MENU.setVisible(true);
	}
	
	
}
