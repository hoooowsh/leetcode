package easy;

public class ReverseLinkedList_206 {
	public static void main(String[] args) {
	}

	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode currnode = head.next;
		ListNode prevnode = head;
		head.next = null;
		while (currnode != null) {
			ListNode temp = currnode.next;
			currnode.next = prevnode;
			prevnode = currnode;
			currnode = temp;
		}
		return prevnode;
	}

	public class ListNode {
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

}
