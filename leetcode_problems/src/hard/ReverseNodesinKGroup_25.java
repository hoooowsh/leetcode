package hard;

import java.util.ArrayList;

public class ReverseNodesinKGroup_25 {
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
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		//l.next.next.next.next.next = new ListNode(2);
		ListNode test = reverseKGroup2(l, 2);
	}

	// This version store k nodes in an arraylist, then reverse it, slow but easy to
	// code
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		int count = 0;
		ListNode cur = head;
		ListNode prev = null;
		boolean boo = true;
		while (cur != null) {
			if (count == 0) {
				list.add(cur);
				cur = cur.next;
				count++;
			} else if (count == k - 1) {
				list.add(cur);
				cur = cur.next;
				count++;
				for (int i = 0; i < count; i++) {
					if (boo) {
						boo = false;
						prev = list.get(list.size() - i - 1);
						head = prev;
					} else {
						prev.next = list.get(list.size() - i - 1);
						prev = prev.next;
					}
				}
				list.removeAll(list);
				count = 0;
			} else {
				list.add(cur);
				cur = cur.next;
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			prev.next = list.get(i);
			prev = prev.next;
		}
		prev.next = null;
		return head;
	}

	
	// faster using linked list logic
	public static ListNode reverseKGroup2(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		// current node
		ListNode cur = head;
		// to store head node to return, not change over iteration
		ListNode prevh = new ListNode(-1);
		// to store previous node
		ListNode prev = prevh;
		// to store previous node from previous round
		ListNode lastround = prev;
		ListNode currentround = prev;
		ListNode tempc = prev;
		int counter = 0;
		while (cur != null) {
			// this is the last node
			if (counter == k - 1) {
				tempc = cur;
				cur = cur.next;
				tempc.next = prev;
				lastround.next = tempc;
				lastround = currentround;
				counter = 0;
			}
			// if this is the current round first node, remember it and go on
			else if (counter == 0) {
				tempc = cur;
				cur = cur.next;
				currentround = tempc;
				prev = tempc;
				counter++;
			}
			// if not the last node
			else {
				tempc = cur;
				cur = cur.next;
				tempc.next = prev;
				prev = tempc;
				counter++;
			}
		}
		// reverse last round if need to
		if (counter != 0) {
			int size = counter;
			cur = tempc;
			counter--;
			prev = null;
			while (counter >= 0) {
				// if this is the first node, connect prev round to current
				if (counter == 0) {
					lastround.next = cur;
					cur.next = prev;
					break;
				}
				// if this is the last node
				else if (counter == size) {
					prev = cur;
					tempc = cur;
					cur = cur.next;
					tempc.next = null;
					counter--;
				}
				// else
				else {
					tempc = cur;
					cur = cur.next;
					tempc.next = prev;
					prev = tempc;
					counter--;
				}
			}
		} else {
			lastround.next = null;
		}
		return prevh.next;
	}
	

	// others solution, using recursion can be fast, beat 100%
	public ListNode reverseKGroup3(ListNode head, int k) {
	    ListNode curr = head;
	    int count = 0;
	    while (curr != null && count != k) { // find the k+1 node
	        curr = curr.next;
	        count++;
	    }
	    if (count == k) { // if k+1 node is found
	        curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
	        // head - head-pointer to direct part, 
	        // curr - head-pointer to reversed part;
	        while (count-- > 0) { // reverse current k-group: 
	            ListNode tmp = head.next; // tmp - next head in direct part
	            head.next = curr; // preappending "direct" head to the reversed list 
	            curr = head; // move head of reversed part to a new node
	            head = tmp; // move "direct" head to the next node in direct part
	        }
	        head = curr;
	    }
	    return head;
	}
}
