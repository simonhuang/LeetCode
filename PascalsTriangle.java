package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main (String [] args){
		generate(9);
	}
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> rows = new ArrayList<List<Integer>>();
		
		for (int i=0;i<numRows;i++){
			List<Integer> row = new ArrayList<Integer>();
			if (i == 0){
				row.add(1);
			} else if (i == 1){
				row.add(1);
				row.add(1);
			} else {
				row.add(1);
				for (int j=0;j<rows.get(i-1).size() - 1;j++){
					row.add(rows.get(i-1).get(j) + rows.get(i-1).get(j+1));
				}
				row.add(1);
			}
			rows.add(row);
		}
		return rows;
    }
}
