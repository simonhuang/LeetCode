package leetCode;

public class ReverseLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main (String [] args){
		ListNode list = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		
		list.next = list2;
		list2.next = list3;
		list3.next = list4;

		ListNode l = reverseList(list);
		
		while (l != null){
			System.out.println(l.val);
			l = l.next;
		}
	}
	public static ListNode reverseList(ListNode head) {
		return reverseListHelper(head, null);
	}
	public static ListNode reverseListHelper(ListNode head, ListNode tail) {
		if (head == null){
			return tail;
		}
		ListNode temp = head.next;
		head.next = tail;
		return reverseListHelper(temp, head);
	}
	
    public static ListNode reverseListIterative(ListNode head) {
        if (head == null){
        	return null;
        } 
    	ListNode temp = head;
    	
    	if (head.next == null){
    		return head;
    	}
    	ListNode temp_next = head.next;
    	
    	if (head.next.next == null){
    		head.next.next = head;
    		head.next = null;
    		return temp_next;
    	}
    	ListNode temp_next_next = head.next.next;
    	
    	temp.next = null;
        while (temp_next != null){
        	temp_next.next = temp;
        	temp = temp_next;
        	temp_next = temp_next_next;
        	if (temp_next_next != null){
        		temp_next_next = temp_next_next.next;
        	}
        	ListNode l = temp;
        	while (l != null){
    			l = l.next;
    		}
        }
        return temp;
    }
}