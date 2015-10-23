package linkedlist;

public class LinkedListCycleII {
	public ListNode detectCycl(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head.next;
		boolean hasCycle = false;
		while (fast != null && fast.next != null && fast.next.next != null) {
			if (slow == fast) {
				hasCycle = true;
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		if (hasCycle == false)
			return null;
		int cycleSize = 1;
		fast = fast.next;
		while (slow != fast) {
			fast = fast.next;
			cycleSize++;
		}
		slow = head;
		fast = head;
		for (int i = 0; i < cycleSize; i++)
			fast = fast.next;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
