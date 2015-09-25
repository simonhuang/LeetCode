package leetCode;

public class ProductExceptSelf {
	public static void main (String [] args){
		int [] a = {1, 2, 3, 4};
		int [] b = productExceptSelf2(a);
		for (int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
		System.out.println(division(24, 4, -1000, 1000));
	}
	public static int[] productExceptSelf(int[] nums) {
        int [] products = new int [nums.length];
        products[0] = 1;
        for (int i=1;i<products.length;i++){
        	products[i] = products[i-1] * nums[i - 1];
        }
        
        int right_product = 1;
        for (int i=products.length-2;i>=0;i--){
        	right_product *= nums[i+1];
        	products[i] *= right_product;
        }
        return products;
    }
	public static int[] productExceptSelf2(int[] nums) {
        int [] products = new int [nums.length];
        int product = 1;
        for (int i=0;i<nums.length;i++){
        	product *= nums[i];
        }
        
        
        for (int i=0;i<products.length;i++){
        	products[i] = division(product, nums[i], -1000, 1000);
        }
        return products;
    }
	public static int division(int dividend, int divisor, int low, int high){
		if (high / 2 == low / 2){
			if (high * divisor == dividend){
				return high;
			} else {
				return low;
			}
		}
		
		int middle = low + high / 2 - low / 2;
		if (middle * divisor == dividend){
			return middle;
		} else if (middle * divisor > dividend){
			return division(dividend, divisor, low, middle-1);
		} else {
			return division(dividend, divisor, middle+1, high);
		}
	}
}
