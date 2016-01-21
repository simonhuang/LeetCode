package leetCode;
import java.util.*;
public class ShortestPalindrome {
	public static void main (String [] args){
		ShortestPalindrome sp = new ShortestPalindrome();
		String s = "aacecaaa";
		System.out.println(sp.shortestPalindrome(s));
	}
    public String shortestPalindrome(String s) {
        
    	int index = (s.length() + 1) / 2;
    	for (int i=index;i>=0;i--){
    		if (i*2 <= s.length()-1){
	    		if (s.substring(0, i).equals(new StringBuilder(s.substring(i, i*2)).reverse().toString())){
	    			return new StringBuilder(s.substring(i*2)).reverse().toString() + s;
	    		} 
    		}
    		if (i*2+1 <= s.length()-1){
	    		if (s.substring(0, i).equals(new StringBuilder(s.substring(i+1, i*2+1)).reverse().toString())){
	    			return new StringBuilder(s.substring(i*2+1)).reverse().toString() + s;
	    		}
    		}
    	}
    	return "";
    }
}
