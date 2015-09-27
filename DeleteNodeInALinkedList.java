package leetCode;

public class DeleteNodeInALinkedList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		void print(){
			System.out.print(val + " ");
			if (next == null){
				System.out.println();
			} else {
				next.print();
			}
		}
	}
	public void deleteNode(ListNode node) {
        if (node.next == null){
        	node = null;
        } else {
        	node.val = node.next.val;
        	node.next = node.next.next;
        }
    }
}
