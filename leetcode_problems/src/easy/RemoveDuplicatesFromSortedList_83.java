package easy;

public class RemoveDuplicatesFromSortedList_83 {
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

	public static void main(String[] args) {
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode cur = head.next;
		ListNode prev = head;
		while (cur != null) {
			if(prev.val == cur.val) {
				cur = cur.next;
				prev.next = cur;
			}else {
				prev = cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
