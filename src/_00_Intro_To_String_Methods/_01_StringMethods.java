package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	if( s1.length() > s2.length()) {
    		return s1;
    	}
        return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if(s.contains("underscores")) {
    		
				s = s.replace(" ", "_");
    	}
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	s1 = s1.trim();
    	s2 = s2.trim();
    	s3 = s3.trim();
    	
    	int one = s1.indexOf(" ") +1 ;
    	int two = s2.indexOf(" ")+1;
    	int three = s3.indexOf(" ") +1;
    	
    	if(s1.charAt(one) < s2.charAt(two)) {
    		if(s1.charAt(one) < s3.charAt(three)) {
    			return s1;
    		}
    	}
    	if(s2.charAt(two) < s1.charAt(one)) {
    		if(s2.charAt(two) < s3.charAt(three)) {
    			return s2;
    		}
    	}
    	
    	
        return s3;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
    	for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i)) == true) {
    		char x = s.charAt(i);
    		int num = Character.getNumericValue(x);
    		sum +=num;
    	}
		}
    	
    	
		
    	 
        
		return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	
    	 int numOccurances = 0;
    	String removedSubstring = s.replace(substring, "");
        numOccurances = (s.length() - removedSubstring.length()) / substring.length();
    	
        return numOccurances;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	
    	
    	
        return Utilities.encrypt(s.getBytes(), (byte) key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	
    	
    	return Utilities.decrypt(s, (byte) key);
        
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	 
    	int num = 0;
			String[] a = s.split(" ");
			for (int i = 0; i < a.length; i++) {
				if(a[i].endsWith(substring)) {
					num +=1;
				}
			}
    	
        return num;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	
    	int x = s.indexOf(substring);
    	int y = s.lastIndexOf(substring);
        return y-x-substring.length();
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	
    	String z = s;
    	String y = "";
    	for (int i = 0; i < z.length(); i++) {
			char x = z.charAt(i);
			if(Character.isLetter(x) == true) {
				
				y = y + Character.toLowerCase(x);
			}
		}
    	System.out.println(y);
    	
    	for (int i = 0; i < y.length()/2; i++) {
			if(y.charAt(i) != y.charAt(y.length()-1-i)) {
				return false;
			}
		}
		
        return true;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
