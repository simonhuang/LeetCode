package leetCode;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] p) {
    	List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
    	for (int i=0;i<n;i++){
    		adj_list.add(new ArrayList<Integer>());
    	}
    	for (int i=0;i<p.length;i++){
    		adj_list.get(p[i][1]).add(p[i][0]);
    	}
    	
    	
    	boolean [] cleared = new boolean [n];
        for (int i=0;i<n;i++){
        	if (cleared[i]){
        		continue;
        	}
        	HashSet<Integer> visited = new HashSet<Integer>();
        	Queue<Integer> course = new LinkedList<Integer>();
        	cleared[i] = true;
        	course.add(i);
        	visited.add(i);
        	while (!course.isEmpty()){
        		for (int c : adj_list.get(course.poll())){
        			if (visited.contains(c)) return false;
        			if (!cleared[c]){
        	        	cleared[c] = true;
        				course.add(c);
        				visited.add(c);
        			}
        		}
        	}
        }
        return true;
    }
}
