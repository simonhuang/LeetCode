package leetCode;

public class MergeTwoSortedLists {
	public static void main (String [] args){
		
	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        while (l1 != null && l2 != null){
        	if (l1.val < l2.val){
        		if (head == null){
        			head = l1;
        			current = head;
        			l1 = l1.next;
        		} else {
        			current.next = l1;
        			current = current.next;
        			l1 = l1.next;
        		}
        	} else {
        		if (head == null){
        			head = l2;
        			current = head;
        			l2 = l2.next;
        		} else {
        			current.next = l2;
        			current = current.next;
        			l2 = l2.next;
        		}
        	}
        }
        if (head == null){
        	if (l1 == null && l2 == null){
        		return null;
        	} else if (l1 == null){
        		head = l2;
        	} else {
        		head = l1;
        	}
        } else {
        	if (l1 == null){
        		current.next = l2;
        	} else {
        		current.next = l1;
        	}
        }
        return head;
    }
}
