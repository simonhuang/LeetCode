package leetCode;

import java.awt.List;
import java.util.ArrayList;

public class PalindromePartitioning {
	public static void main (String [] args){
		
	}
//	public ArrayList<ArrayList<String>> partition(String s) {
//		ArrayList<ArrayList<String>> main_list = new ArrayList<ArrayList<String>>();
//		
//		for (int i=1;i<s.length();i++){
//			if (is_palindrome(s.substring(0,i))){
//				
//			}
//		}
//		return "";
//    }
	boolean is_palindrome(String s){
		return s.equals(new StringBuilder(s).reverse().toString());
	}
}
