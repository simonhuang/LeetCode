package leetCode;

public class BuySellStock {
	public static void main (String [] args){
		int a[] = {1, 2};
		
		System.out.println(maxProfit(a));
	}
	
	public static int maxProfit (int[] prices){
		int profit = 0;
		int buy_price = Integer.MAX_VALUE;
		
		boolean  bought = false;
		
		if (prices.length <= 1){
			return 0;
		}
		if (prices[1] > prices[0]){
			buy_price = prices[0];
			bought = true;
		}
		for (int i=1;i<prices.length;i++){
			if (!bought){
				if (prices[i] > prices[i-1]){
					buy_price = prices[i-1];
					bought = true;
				} 
			} else {
				if (prices[i] < prices[i-1]){
					profit += (prices[i-1] - buy_price);
					bought = false;
				}
			}
		}
		if (bought){
			profit += prices[prices.length-1] - buy_price;
		}
		
		return profit;
	}
	public static int maxProfitOneTransaction(int[] prices) {
        int buy_point = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int i=0;i<prices.length;i++){
        	if (prices[i] < buy_point){
        		buy_point = prices[i];
        	}
        	if (prices[i] - buy_point > profit){
        		profit = prices[i] - buy_point;
        	}
        }
		
		return profit;
    }
}
