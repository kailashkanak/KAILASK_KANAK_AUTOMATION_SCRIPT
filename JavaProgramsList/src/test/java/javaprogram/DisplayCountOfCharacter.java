package javaprogram;

import java.util.HashMap;

public class DisplayCountOfCharacter {

	public static void main(String[] args) {
		String str = "kailash prasad kanak";
		
		char ch[] = str.toCharArray();
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		
		for(char c:ch)
		{
			if(hm.containsKey(c))
			{
				hm.put(c, hm.get(c)+1);
			}
			else
			{
				hm.put(c, 1);
			}
		}
		System.out.println(hm);
	}

}
