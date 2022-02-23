package com.brillio.junit;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeTest {

	@ParameterizedTest
	@ValueSource(strings= {"racecar","madam"})
	public void TestPalindrome(String str) {
		
		PalindromeCheck pc=new PalindromeCheck();
		boolean actual=pc.isPalindrome(str);
		assertTrue(actual);
	}
}
