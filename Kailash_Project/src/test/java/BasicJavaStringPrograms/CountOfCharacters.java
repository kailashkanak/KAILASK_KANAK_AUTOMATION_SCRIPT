package BasicJavaStringPrograms;

import java.util.HashMap;

public class CountOfCharacters {
	
	public static HashMap<Character,Integer> countOfCharacter(String myStr)
	{
		char[] ch = myStr.toCharArray();
		
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
		return hm;
	}

	public static void main(String[] args) 
	{
		String str = "Hello World";
		
		HashMap<Character,Integer> count = countOfCharacter(str);
		
		System.out.println(count);

	}

}
