package leetCode;
import java.util.*;
public class MinimumWindowSubstring {
	public static void main (String [] args){
		String t = "a";
		String s = "aa";
		MinimumWindowSubstring a = new MinimumWindowSubstring();
		System.out.println(a.minWindow(t, s));
	}
    public String minWindow(String t, String s) {
        HashSet<Character> s_chars = new HashSet<Character>();
        for (int i=0;i<s.length();i++){
        	s_chars.add(s.charAt(i));
        }
        
        int start = 0;
        int end = 0;
        
        HashMap<Character, Integer> t_chars = new HashMap<Character, Integer>();
        for (int i=0;i<t.length();i++){
        	insert(t_chars, s_chars, t.charAt(i));
        	if (t_chars.size() == s_chars.size()){
        		end = i;
        		break;
        	}
        }
        if (t_chars.size() < s_chars.size()){
        	return "";
        }
        if (start == end){
        	return t.substring(start, end + 1);
        }
        
        int best_start = start;
        int best_end = end;
        boolean window = true;
        while (true){
    		while (window){
    			char c = t.charAt(start);
    			start ++;
    			remove(t_chars, s_chars, c);
    			if (t_chars.size() < s_chars.size()){
    				window = false;
    			} else {
    				if (start == end){
    					return t.substring(start, end + 1);
    				}
        			best_start = start;
        			best_end = end;
    			}
        	}
    		if (end + 1 >= t.length()) break;
			remove(t_chars, s_chars, t.charAt(start));
			start ++;
			end ++;
    		insert(t_chars, s_chars, t.charAt(end));
    		if (t_chars.size() == s_chars.size()){
    			window = true;
    			best_start = start;
    			best_end = end;
    		}
        }
        return t.substring(best_start, best_end + 1);
    }
    public void remove (HashMap<Character, Integer> t_chars, HashSet<Character> s_chars, char c){
    	if (t_chars.containsKey(c)){
			if (t_chars.get(c) == 1){
				t_chars.remove(c);
			} else {
				int count = t_chars.get(c);
				t_chars.put(c, count-1);
			}
		}
    }

    public void insert (HashMap<Character, Integer> t_chars, HashSet<Character> s_chars, char c){
    	if (s_chars.contains(c)){
    		if (t_chars.containsKey(c)){
    			int count = t_chars.get(c);
    			t_chars.put(c, count+1);
    		} else {
    			t_chars.put(c, 1);
    		}
    	}
    }
}
