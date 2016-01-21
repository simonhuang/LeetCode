package leetCode;

public class AddDigits {
	public int addDigits(int num) {
        int result = 0;
        while (num > 0){
        	int cur_digit = num % 10;
        	num /= 10;
        	result += cur_digit;
        }
        if (result < 10){
        	return result;
        } else {
        	return addDigits(result);
        }
    }
}
