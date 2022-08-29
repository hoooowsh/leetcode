package easy;

import java.util.HashSet;

public class IntersectionofTwoLinkedlists_160 {
	public static void main(String[] args) {

	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> hashA = new HashSet<>();
		HashSet<ListNode> hashB = new HashSet<>();
		while (headA != null || headB != null) {
			if (headA != null && headB != null) {
				if (hashA.contains(headB)) {
					return headB;
				}
				if (hashB.contains(headA)) {
					return headA;
				}
				hashA.add(headA);
				if (hashA.contains(headB)) {
					return headB;
				}
				hashB.add(headB);
				headA = headA.next;
				headB = headB.next;
			} else if (headB != null) {
				if (hashA.contains(headB)) {
					return headB;
				}
				hashB.add(headB);
				headB = headB.next;
			} else {
				if (hashB.contains(headA)) {
					return headA;
				}
				hashA.add(headA);
				headA = headA.next;
			}
		}
		return null;
	}

	// This approach first getting the size of two linkedlist, then skip the longer
	// list first part, start finding common node from the second part of two lists,
	// space can be reduced to 1 using this approach
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		int sizeA = getsize(headA);
		int sizeB = getsize(headB);
		for (int i = 0; i < Math.abs(sizeA - sizeB); i++) {
			if (sizeA > sizeB) {
				headA = headA.next;
			} else {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}

			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public static int getsize(ListNode node) {
		int counter = 0;
		ListNode temp = node;
		while (temp != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
