package leetCode;

import leetCode.DeleteNodeInALinkedList.ListNode;

public class Test {
	public static void main (String [] args){
		DeleteNodeInALinkedList d = new DeleteNodeInALinkedList();
		ListNode n = d.new ListNode(5);
		ListNode n1 = d.new ListNode(6);
		ListNode n2 = d.new ListNode(7);
		n.next = n1;
		n1.next = n2;
		n.print();
		d.deleteNode(n1);
		n.print();
	}
}
