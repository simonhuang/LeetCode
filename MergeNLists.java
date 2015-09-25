package leetCode;

import java.util.PriorityQueue;

public class MergeNLists {
	public static void main (String [] args){
		ListNode [] a = new ListNode[3];
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		
		l1.next = l4;
		l4.next = l7;
		l2.next = l5;
		l5.next = l8;
		l3.next = l6;
		l6.next = l9;
		a[0] = l1;
		a[1] = l2;
		a[2] = l3;
		
		ListNode merged = mergeKLists(a);
		while (merged != null){
			System.out.println(merged.val);
			merged = merged.next;
		}
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode (int x) { val = x; }
	}
	static class NodeEntry implements Comparable<NodeEntry>{
		ListNode node;
		int list_source;
		NodeEntry(ListNode node, int list_source){
			this.node = node;
			this.list_source = list_source;
		}
		@Override
		public int compareTo(NodeEntry ne) {
			// TODO Auto-generated method stub
			return node.val - ne.node.val;
		}
	}
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = null;
        ListNode cur_merged = merged;
        
        PriorityQueue<NodeEntry> pq = new PriorityQueue<NodeEntry>();
        
        for (int i=0;i<lists.length;i++){
        	if (lists[i] != null){
        		pq.add(new NodeEntry(lists[i], i));
        		lists[i] = lists[i].next;
        	}
        }
        while (!pq.isEmpty()){
        	NodeEntry ne = pq.poll();
        	ListNode node = ne.node;
        	if (merged == null){
        		merged = node;
        		cur_merged = node;
        	} else {
        		cur_merged.next = node;
        		cur_merged = cur_merged.next;
        	}
        	if (lists[ne.list_source] != null){
        		pq.add(new NodeEntry(lists[ne.list_source], ne.list_source));
        		lists[ne.list_source] = lists[ne.list_source].next;
        	}
        }
        return merged;
    }
}
