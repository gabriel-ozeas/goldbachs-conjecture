package com.gabrielozeas.goldbachs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GoldbachAnalyserTest {
	
	GoldbachAnalyser analyser;
	
	@Before
	public void setUp() throws Exception {
		analyser = new GoldbachAnalyser();
	}
	
	@Test
	public void analysingNumber1() throws Exception {
		String[] expressions = analyser.analyseConjecture(1);
		assertEquals(0, expressions.length);
	}
	
	@Test
	public void analysingNumber2() throws Exception {
		String[] expressions = analyser.analyseConjecture(2);
		assertEquals(0, expressions.length);
	}
	
	@Test
	public void analysingNumber3() throws Exception {
		String[] expressions = analyser.analyseConjecture(3);
		assertEquals(1, expressions.length);
		assertEquals("1 + 2", expressions[0]);
	}
	
	@Test
	public void analysingNumber8() throws Exception {
		String[] expressions = analyser.analyseConjecture(8);		
		assertEquals(2, expressions.length);
		assertEquals("1 + 7", expressions[0]);
		assertEquals("3 + 5", expressions[1]);
	}
	
	@Test
	public void analysingNumber10() throws Exception {
		String[] expressions = analyser.analyseConjecture(10);		
		assertEquals(2, expressions.length);
		assertEquals("3 + 7", expressions[0]);
		assertEquals("5 + 5", expressions[1]);
	}
	
	@Test
	public void analysingNumber14() throws Exception {
		String[] expressions = analyser.analyseConjecture(14);		
		assertEquals(3, expressions.length);
		assertEquals("1 + 13", expressions[0]);
		assertEquals("3 + 11", expressions[1]);
		assertEquals("7 + 7", expressions[2]);
	}
	
	@Test
	public void analysingNumber22() throws Exception {
		String[] expressions = analyser.analyseConjecture(22);		
		assertEquals(3, expressions.length);
		assertEquals("3 + 19", expressions[0]);
		assertEquals("5 + 17", expressions[1]);
		assertEquals("11 + 11", expressions[2]);
	}
	
}
