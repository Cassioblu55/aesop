package com.cassiohudson.aesop.userInterface;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.cassiohudson.aesop.dao.CharacterExperienceHome;
import com.cassiohudson.aesop.domain.CharacterExperience;
import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.utils.FrameUtils;

public class CharacterExperienceFrame {
	//private static List<Checkbox> checkBoxList = new ArrayList<Checkbox>();
	private static final List<Integer> LEVEL_AMOUNT = new ArrayList<Integer>(Arrays.asList(0,300,900,2700,6500,14000,23000,34000,85000,100000,120000,140000,165000,195000,225000,265000,305000,355000));
	
	public static JFrame getFrame(){
		List<CharacterExperience> list = new CharacterExperienceHome().getAllCharacters();
		final JFrame frame = FrameUtils.getDefautFrame("Character Experience");
		frame.setLayout(new GridLayout((list.size()*2), 3));
		for(final CharacterExperience ce : list){
			
			final JTextField jtf = new JTextField();
			JLabel lable = new JLabel(ce.getName().concat(": "));
			//row 1
			frame.add(lable);
			frame.add(jtf);
			
			final JButton button = new JButton("Add");
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Integer i = Integer.parseInt(jtf.getText());					
					new CharacterExperienceHome().addExperience(ce, i);
					Aesop.EXPERIENCE_MENU.dispose();
					Aesop.EXPERIENCE_MENU = CharacterExperienceFrame.getFrame();
					Aesop.EXPERIENCE_MENU.setVisible(true);
					
				}
			});
			frame.add(button);
			
			//row 2
			frame.add(new JLabel("Level: ".concat(getLevel(ce.getExperience()).toString())));
			frame.add(new JLabel("Current XP: ".concat(ce.getExperience().toString())));
			frame.add(new JLabel("Exp till next Level: ".concat(getToNextLevel(ce.getExperience()))));
		}

		frame.pack();
		return frame;
	}
	
	
	private static String getToNextLevel(Integer exp){
		Integer level = getLevel(exp);
		if(level.equals(20)){return "--";}
		Integer needed = LEVEL_AMOUNT.get(level);
		Integer n = needed - exp;
		return n.toString();
	}
	
	private static Integer getLevel(Integer exp){
		for(int i=0; i<LEVEL_AMOUNT.size()-1; i++){
			if(exp<LEVEL_AMOUNT.get(i)){
				return i;
			}
		}
		return 20;
	}
	
	
}
