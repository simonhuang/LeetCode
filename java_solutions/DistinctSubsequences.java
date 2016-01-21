package leetCode;

import java.util.HashSet;

public class DistinctSubsequences {
	public static void main (String [] args){
		String s = "oirabbbffffffit";
		String t = "rabbit";
		System.out.println(numDistinct(s, t));
	}
	public static int numDistinct(String s, String t) {
		StringBuilder sb = new StringBuilder();
		HashSet<Character> chars = new HashSet<Character>();
		for (int i=0;i<t.length();i++){
			chars.add(t.charAt(i));
		}
		
		for (int i=0;i<s.length();i++){
			if (chars.contains(s.charAt(i))){
				sb.append(s.charAt(i));
			}
		}
		
		s = sb.toString();
		
		int count [] = new int [t.length()];
		
		for (int i=0;i<s.length();i++){
			for (int j=count.length-1;j>=0;j--){
				if (s.charAt(i) == t.charAt(j)){
					if (j == 0){
						count[j] ++;
					} else {
						count[j] += count[j-1];
					}
				}
			}
		}
		
		return count[count.length - 1];
    }
}
