package leetCode;

public class GasStation {
	public static void main (String [] args){
		
	}
	
	public static int canCompleteCircuit2(int[] gas, int[] cost) {
		for (int i=0;i<gas.length;i++){
			int index = i;
			int cur_gas = 0;
			while (true){
				cur_gas += gas[index];
				if (cur_gas < cost[index]){
					break;
				}
				cur_gas -= cost[index];
				
				if (index == gas.length - 1){
					index = 0;
				} else {
					index ++;
				}
				if (index == i){
					return i;
				}
			}
		}
        return -1;
    }
}
