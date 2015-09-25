package leetCode;

import java.util.HashSet;

public class DecodeWays {
	public static void main (String [] args){
		String s = "301";
		System.out.println(numDecodings(s));
	}
	public static int numDecodings(String s) {
		if (s.length() == 0){
			return 0;
		}
        HashSet<Integer> encodings = new HashSet<Integer>();
        for (int i=1;i<27;i++){
        	encodings.add(i);
        }
        
        int decodings [] = new int [s.length()];
        if (s.charAt(0) == '0'){
        	return 0;
        }
        if (s.length() == 1){
        	return 1;
        }
        
    	decodings[0] = 1;
    	if (encodings.contains(Integer.parseInt(s.substring(0,2))) && s.charAt(1) != '0'){
    		decodings[1] = 2;
    	} else {
    		decodings[1] = 1;
    	}
    	
    	for (int i=1;i<s.length();i++){
    		if (s.charAt(i) == '0'){
    			if (s.charAt(i-1) != '2' && s.charAt(i-1) != '1'){
    				return 0;
    			}
    		}
    	}
    	
        for (int i=2;i<s.length();i++){
        	if (encodings.contains(Integer.parseInt(s.substring(i-1,i+1))) && s.charAt(i-1) != '0'){
        		if (s.charAt(i) != '0'){
        			decodings[i] = decodings[i-1] + decodings[i-2];
        			System.out.println('a');
        		} else {
        			decodings[i] = decodings[i-2];
        			System.out.println('b');
        		}
        	} else {
        		if (s.charAt(i) == '0'){
        			System.out.println('c');
        			return 0;
        		} else {
        			decodings[i] = decodings[i-1];
        			System.out.println('d');
        		}
        	}
        }
        
        return decodings[s.length() - 1];
    }
}
