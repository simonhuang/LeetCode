package leetCode;
import java.util.*;
public class MinimumWindow {
	public static void main (String [] args){
		String S = "ADOBECODEBANC";
		String T = "ABC";
		
	}
	class Node implements Comparable<Node>{
		char character;
		int index;
		public Node (char character, int index){
			this.character = character;
			this.index = index;
		}
		@Override
		public int compareTo(Node n) {
			return this.index - n.index;
		}
	}
	public static String minWindow(String S, String T) {
		
		char characters [] = new char [T.length()];
		int character_indicies [] = new int [T.length()];
		
		for (int i=0;i<T.length();i++){
			characters[i] = T.charAt(i);
		}
		
		Arrays.fill(character_indicies, -1);
		int chars_found = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		
		int min_window_start = 0;
		int min_window_end = 0;
		
		for (int i=0;i<S.length();i++){
			if (Arrays.asList(characters).contains(S.charAt(i))){
			}
		}
		
		return T;
    }
	public static boolean allFound (boolean a[]){
		for (int i=0;i<a.length;i++){
			if (! a[i]){
				return false;
			}
		}
		return true;
	}
}
