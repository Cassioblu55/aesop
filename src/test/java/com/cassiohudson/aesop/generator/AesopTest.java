package com.cassiohudson.aesop.generator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AesopTest {

	@Test
	public void aesopAddLineShouldAddLineToString(){
		String s = Aesop.addLine("test");
		assertEquals("test\n\n",s);
	}
	
	@Test
	public void addBlankLineShouldReturnBlankLine(){
		assertEquals("\n", Aesop.addBlankLine(1));
	}
	
	@Test
	public void getRandomStringShouldReturnRandomString(){
		List<String> list = Arrays.asList("Test","Test","Test");
		assertEquals("Test", Aesop.getRandomString(list));
	}
	
	@Test
	public void getRandomShouldReturnNumberBetweenTwoValues(){
		
		Integer n = Aesop.getRandom(1, 3);
		assertTrue(n>=1);
		assertTrue(n<=3);
		
		n = Aesop.getRandom(2, 5);
		assertTrue(n>=2);
		assertTrue(n<=5);
	}
	
	
	
}

