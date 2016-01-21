package leetCode;
import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap, List> anagrams = new HashMap<HashMap, List>();
        
        for (String s : strs){
        	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        	for (char c : s.toCharArray()){
        		if (map.containsKey(c)){
        			int count = map.get(c);
        			map.put(c, count + 1);
        		} else {
        			map.put(c, 1);
        		}
        	}
        	if (anagrams.containsKey(map)){
        		List l = anagrams.get(map);
        		l.add(s);
        	} else {
        		List<String> l = new ArrayList<String>();
        		l.add(s);
        		anagrams.put(map, l);
        	}
        }
        List<List<String>> output = new ArrayList<List<String>>();
        for (Map.Entry<HashMap, List> entry : anagrams.entrySet()){
        	Collections.sort(entry.getValue());
        	output.add(entry.getValue());
        }
        return output;
    }
}
