package leetCode;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int n = 0;
        
        for (int i=1;i<s.length()+1;i++){
        	char c = s.charAt(s.length() - i);
        	int num = c - 'A' + 1;
        	num *= Math.pow(26, i-1);
        	n += num;
        }
        return n;
    }	
}
