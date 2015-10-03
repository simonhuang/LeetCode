package leetCode;
import java.util.*;

public class Test {
	class Node{
		int value;
		int weight;
		public Node (int value, int weight){
			this.value = value;
			this.weight = weight;
		}
		
		public String toString(){
			return this.value + " " + this.weight;
		}
		public int hashCode(){
			return this.weight * 31 + this.value;
		}
		public boolean equals(Object o){
			if (! (o instanceof Node)){
				return false;
			} else if (o == this){
				return true;
			}
			Node n = (Node) o;
			return this.value == n.value && this.weight == n.weight;
		}
	}
	public static void main (String [] args){
		Test t = new Test();
		Set<Node> set = new HashSet<Node>();
		List<Integer> l1 = new ArrayList<Integer>();
		Node n = t.new Node(3, 5);
		Node n2 = t.new Node(3, 5);
		set.add(n);
		set.add(n2);
		System.out.println(set);
	}
}