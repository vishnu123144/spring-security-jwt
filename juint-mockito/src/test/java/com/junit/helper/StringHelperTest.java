package com.junit.helper;

import static org.junit.Assert.*;


import org.junit.Test;

import com.junit.StringHelper;

public class StringHelperTest {
	
	StringHelper helper=new StringHelper();
	
	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals("CC", helper.truncateAInFirst2Positions("AACC"));
	}
   
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		assertEquals(true, helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Second() {
		assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ACAB"));
	}
	
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		assertFalse( 
				helper.areFirstAndLastTwoCharactersTheSame("AAAB"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		assertTrue( 
				helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}


}
