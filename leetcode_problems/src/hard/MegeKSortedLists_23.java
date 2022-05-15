package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MegeKSortedLists_23 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode[] test = new ListNode[3];
		test[0] = new ListNode(1);
		test[0].next = new ListNode(4);
		test[0].next.next = new ListNode(5);
		test[1] = new ListNode(1);
		test[1].next = new ListNode(3);
		test[1].next.next = new ListNode(4);
		test[2] = new ListNode(2);
		test[2].next = new ListNode(6);
		mergeKLists(test);
	}

	// dump version, searching through every elements to get smallest
	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null;
		if (lists == null || lists.length == 0) {
			return head;
		}
		// first loop find the head for return
		int min = Integer.MAX_VALUE;
		int minindex = -1;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				if (lists[i].val < min) {
					min = lists[i].val;
					head = lists[i];
					minindex = i;
				}
			}
		}
		if (minindex == -1) {
			return null;
		}
		ListNode cur = head;
		lists[minindex] = lists[minindex].next;

		// start merging
		boolean condition = true;
		while (condition) {
			int ncount = 0;
			int curmin = Integer.MAX_VALUE;
			int curminindex = -1;
			ListNode minnode = new ListNode();
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] == null) {
					ncount++;
				} else {
					if (lists[i].val < curmin) {
						minnode = lists[i];
						curmin = lists[i].val;
						curminindex = i;
					}
				}
			}
			if (ncount == lists.length) {
				break;
			}
			cur.next = minnode;
			cur = cur.next;
			lists[curminindex] = lists[curminindex].next;
		}
		cur.next = null;
		return head;
	}

	// This version using priority queue to improve performance
	public static ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		for (ListNode node : lists)
			if (node != null)
				queue.add(node);

		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;

			if (tail.next != null)
				queue.add(tail.next);
		}
		return dummy.next;
	}
}
