package com.cassiohudson.aesop.utils;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CreateOutputFile {
	
	public static void outPutFile(String text, String pathName){
		try {
			File file = new File(pathName);
			Writer writer = new BufferedWriter(new FileWriter(file));
			writer.write(text);
			writer.close();
			Desktop.getDesktop().open(file);
		}catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
