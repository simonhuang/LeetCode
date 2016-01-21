package leetCode;


public class ListNode {
	int val;
	ListNode next;
	ListNode (int x) { val = x; }
	public String toString(){
		if (next == null){
			return Integer.toString(val);
		} else {
			return val + " " + next.toString();
		}
	}
}
