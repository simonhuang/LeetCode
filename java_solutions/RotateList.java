package leetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
	public static void main (String [] args){
		ListNode l = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		l.print();
		
		rotateRight(l, 11).print();
		
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode (int x) { val = x; }
		public void print (){
			System.out.print(val);
			if (next == null){
				System.out.println();
			} else {
				next.print();
			}
		}
	}
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int list_length = 0;
        
        ListNode tail = null;
        while (cur != null){
        	if (cur.next == null){
        		tail = cur;
        	}
        	cur = cur.next;
        	list_length ++;
        }
        
        if (list_length <= 1){
        	return head;
        }
        
        k = k % list_length;
        if (k == 0){
        	return head;
        }
        int new_head_index = list_length - k;
        ListNode new_head = head.next;
        ListNode new_tail = head;
        
        for (int i=0;i<new_head_index-1;i++){
        	new_head = new_head.next;
        	new_tail = new_tail.next;
        }
        
        tail.next = head;
        new_tail.next = null;
        return new_head;
    }
}