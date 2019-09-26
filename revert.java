		import java.io.*;
		import java.util.*;
/**
* @author maksgod
*/
public class codeTask 
{
public static void main(String[] args) {
	if(args.length!=2)
	{
		System.out.println("Must be specified two words");
		System.exit(0);
	}
	
		Revert revert = new Revert(new File("src/dictionary.txt"));
		System.out.println("Reverting word from '" + args[0] + "' to '" + args[1] + "'" );
		revert.revert(args[0],args[1]);
	}
}
class Revert {
		private Map<Integer, Set> mapDictionary = new HashMap<>();
			Revert(File dictionary) {
			Set<String> words = new HashSet<>();
			try (BufferedReader reader = new BufferedReader(new FileReader(dictionary))) {
				String word;
				while((word = reader.readLine()) != null) words.add(word);
			} catch (IOException e) {
			e.printStackTrace();
		}
		mapDictionary = createMap(words);
}

private Map<Integer, Set> createMap(Set<String> words)
{
		Map<Integer, Set> map = new HashMap<>();
			for(String word : words)
			{
				Set<String> set = map.get(word.length());
				if(set == null )
{
		set = new HashSet<>();
		map.put(word.length(), set);
}
		set.add(word);
}
		return map;
}
		void revert(String from, String to){
		if(from.length() != to.length()){
		System.
}
		Set<String> set = mapDictionary.get(from.length());

		String tempWord = from, prevTempWord = from;
		while(!tempWord.equals(to)) 
		{
			for (String word : set) 
			{
				if (checkWord(tempWord, word, to)) 
				{
					tempWord = word;
					System.out.println(tempWord);
					break;
				}
			}
if(tempWord.equals(prevTempWord))
{
		System.out.println("Cannot find words for revert");
		return;
}
		prevTempWord = tempWord;
}
}
		private boolean checkWord(String tempWord, String word, String to) {
		int equalsCharsWithCurrent = 0;
		int equalsCharsWithEnd = 0;
		for(int i = 0; i < tempWord.length(); i++){
		if(tempWord.charAt(i) != word.charAt(i)){
		if(to.charAt(i) != word.charAt(i)){
		return false;
}
 else 
{
	equalsCharsWithEnd++;
}	
} 
else 
{
equalsCharsWithCurrent++;
}
}
return equalsCharsWithCurrent == tempWord.length()-1 && equalsCharsWithEnd == 1;
}
}
