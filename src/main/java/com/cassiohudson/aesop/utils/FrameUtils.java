package com.cassiohudson.aesop.utils;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.userInterface.ButtonGenerator;

public class FrameUtils {
	
	public static JFrame getMainFrame(){
		JFrame frame = getDefautFrame("Aesop");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		for(JButton jButton : ButtonGenerator.getAllButtons()){
			frame.add(jButton);
		}
		frame.pack();
		return frame;
	}
	
	
	public static JFrame getButtonFrame(String title, List<JButton> list){
		
		JFrame frame = getDefautFrame(title);
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		for(JButton jButton : list){
			frame.add(jButton);
		}
		frame.pack();
		
		return frame;
		
	}
	
	
	public static JFrame getDefautFrame(String title){
		FlowLayout flowLayout = new FlowLayout();
		JFrame frame = new JFrame(title);
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		frame.setLayout(flowLayout);
		frame.setSize(Aesop.WIDTH, Aesop.HEIGHT);
		
		return frame;
	}
	
	public static JButton getMoveButton(String buttonText, final JFrame goTo, final JFrame from){
		
		JButton button = new JButton(buttonText);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goTo.setVisible(true);
				from.setVisible(false);
			}
		});
		return button;
	}
	
	
	
	
	
}
