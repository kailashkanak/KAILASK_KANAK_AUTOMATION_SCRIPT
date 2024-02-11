package BasicJavaStringPrograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOfDuplicateChasracter {
	
	public static List<Character> findDuplicateCharacters(String myString)
	{
		char[] ch=myString.toCharArray();
		
		List<Character> duplicate = new ArrayList<Character>();
		
		Set<Character> seen = new HashSet<Character>();
		
		for(char c:ch)
		{
			if(!seen.add(c))
			{
				duplicate.add(c);
			}
		}
		
		return duplicate;
	}

	public static void main(String[] args) {
		String str = "kailash kanak";
		
		List<Character> duplicateList = findDuplicateCharacters(str);
		
		System.out.println(duplicateList);

	}

}
