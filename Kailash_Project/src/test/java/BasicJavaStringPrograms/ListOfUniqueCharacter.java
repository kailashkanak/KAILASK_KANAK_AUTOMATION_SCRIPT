package BasicJavaStringPrograms;

import java.util.HashSet;
import java.util.Set;

public class ListOfUniqueCharacter {
	
	public static Set<Character> findUniueCharacter(String myString)
	{
		char[] ch=myString.toCharArray();
		
		Set<Character> unique = new HashSet<Character>();
		
		for(char c:ch)
		{
			unique.add(c);
		}
		
		return unique;
	}

	public static void main(String[] args) 
	{
		String str = "Kailash Prasad Kanak";
		
		str=str.toLowerCase();
		
		Set<Character> uniqueList = findUniueCharacter(str);
		
		System.out.println(uniqueList);
	}

}
