package com.my.TestNGTutorial;


public class TestPalindrome {
	
	
	 //===========================================================
	   //  Creates a Palindrome_Tester object, and tests several
	   //  strings.
	   //===========================================================
	   public static void main (String[] args) {

	      TestPalindrome tester = new TestPalindrome();
	      
	      System.out.println ("radar is a palindrome? "
	         + tester.ptest ("SaaS"));
  System.out.println ("abcddcba is a palindrome? "
	         + tester.ptest ("abcddcba"));
/*
	      System.out.println ("able was I ere I saw elba is a palindrome? "
	         + tester.ptest ("able was I ere I saw elba"));

	      System.out.println ("hello is a palindrome? "
	         + tester.ptest ("hello"));

	      System.out.println ("abcxycba is a palindrome? "
	         + tester.ptest ("abcxycba"));*/

	   }  // method main

	
	
	public boolean ptest (String str) {
		System.out.println("---------->"+str);
	      boolean result = false;

	      if (str.length() <= 1)
	         result = true;
	      else
	         if (str.charAt (0) == str.charAt (str.length()-1))
	            result = ptest (str.substring (1, str.length()-1));

	      return result;

	   }
}
