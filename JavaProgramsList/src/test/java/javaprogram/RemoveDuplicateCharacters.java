package javaprogram;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		String str = "Kailash Prasad Kanak";
		
		char ch[]=str.toCharArray();
		
		Set<Character> unique = new HashSet<Character>();
		
		for(char c:ch)
		{
			unique.add(c);
		}
		
		System.out.println(unique);
 
	}

}
