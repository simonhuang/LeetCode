package leetCode;

public class Numberof1Bits {
	public static int hammingWeight(long n) {
        if (n == 0){
        	return 0;
        } else {
        	return (int) (n%2 + hammingWeight(n/2));
        }
    }
	public static void main (String[] args){
		System.out.println(hammingWeight(2147483648L));
	}
}
