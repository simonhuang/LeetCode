package leetCode;
import java.util.*;
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
    	if (s.length() != t.length()){
    		return false;
    	}
    	
        HashMap<Character, Integer> s1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> s2 = new HashMap<Character, Integer>();
        
        for (int i=0;i<s.length();i++){
        	if (s1.containsKey(s.charAt(i))){
        		s1.put(s.charAt(i), s1.get(s.charAt(i)) + 1);
        	} else {
        		s1.put(s.charAt(i), 1);
        	}
        }
        for (int i=0;i<t.length();i++){
        	if (s2.containsKey(t.charAt(i))){
        		s2.put(t.charAt(i),	s2.get(t.charAt(i)) + 1);
        	} else {
        		s2.put(t.charAt(i), 1);
        	}
        }

        if (s1.size() != s2.size()){
        	return false;
        } 
        
        for (Map.Entry<Character, Integer> entry : s1.entrySet()){
        	if (!s2.containsKey(entry.getKey())){
        		return false;
        	}
        	if (s2.get(entry.getKey()) != entry.getValue()){
        		return false;
        	}
        }
        return true;
    }
}
