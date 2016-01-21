package leetCode;
import java.util.*;
public class AddTwoNumbers {
	public static void main (String [] args){
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode n1 = a.new ListNode(5);
		ListNode n2 = a.new ListNode(6);
		ListNode n3 = a.new ListNode(1);
		ListNode n4 = a.new ListNode(3);
		
		n1.next = n2;
		n3.next = n4;
		
		ListNode l = a.addTwoNumbers(n1, n3);
		while (l!= null){
			System.out.println(l.val);
			l = l.next;
		}
	}
	class ListNode{
		int val;
		ListNode next;
		ListNode (int val) {this.val = val;}
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        while (l1 != null){
        	sb1.append(l1.val);
        	l1 = l1.next;
        }
        
        StringBuilder sb2 = new StringBuilder();
        while (l2 != null){
        	sb2.append(l2.val);
        	l2 = l2.next;
        }
        
        int n1 = Integer.parseInt(sb1.toString());
        int n2 = Integer.parseInt(sb2.toString());
        
        String result = Integer.toString(n1+n2);
        
        ListNode l = new ListNode(0);
        ListNode head = l;
        for (int i=0;i<result.length();i++){
        	l.val = Integer.parseInt(result.substring(i,i+1));
        	if (i != result.length() - 1){
	        	l.next = new ListNode(0);
	        	l = l.next;
        	}
        }
        return head;
    }
}
