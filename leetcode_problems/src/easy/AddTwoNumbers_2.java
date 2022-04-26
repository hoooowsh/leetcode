package easy;

public class AddTwoNumbers_2 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	
	
	// simple linked list adding integers 
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode res = new ListNode(-1), tail = res;
		while (l1 != null || l2 != null || sum >= 10) {
			sum /= 10;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			tail.next = new ListNode(sum % 10);
			tail = tail.next;
		}
		return res.next;
	}
}
