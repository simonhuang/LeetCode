package leetCode;
import java.util.*;

public class Test {
	public static void main (String [] args){
		GroupAnagrams ga = new GroupAnagrams();
		String [] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(ga.groupAnagrams(test));
	}
}