package leetCode;
import java.util.*;
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotalHelper(triangle, null);
    }
	int minimumTotalHelper(List<List<Integer>> triangle, List<Integer> prev){
		if(prev == null){
			prev = new LinkedList<Integer>();
			prev.add(triangle.get(0).get(0));
			return minimumTotalHelper(triangle, prev);
		}
		List<Integer> cur = new LinkedList<Integer>();
		List<Integer> level = triangle.get(prev.size());
		cur.add(level.get(0) + prev.get(0));
		for (int i=1;i<prev.size();i++){
			cur.add(Math.min(prev.get(i-1), prev.get(i)) + level.get(i));
		}
		cur.add(level.get(prev.size()) + prev.get(prev.size()-1));
		if (cur.size() == triangle.size()){
			int min = cur.get(0);
			for (int n : cur){
				if (n < min){
					min = n;
				}
			}
			return min;
		} else {
			return minimumTotalHelper(triangle, cur);
		}
	}
	
    public int minimumTotalSlow(List<List<Integer>> triangle) {
        return minimumTotalSlowHelper(triangle, 0, 0, 0);
    }
    public int minimumTotalSlowHelper(List<List<Integer>> triangle, int index, int level, int total){
    	if (level == triangle.size()) return total;
    	return Math.min(minimumTotalSlowHelper(triangle, index, level+1, total+triangle.get(level).get(index)),
    					minimumTotalSlowHelper(triangle, index, level+1, total+triangle.get(level).get(index)));
    }
}
