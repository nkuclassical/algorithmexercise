package sort;

import linkedlist.ListNode;

public class InsertionSortList {
	
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head.next;
		head.next = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = null;
			ListNode sortcur = head;
			if (cur.val < head.val) {
				cur.next = head;
				head = cur;
			} else {
				while (sortcur.next != null && cur.val > sortcur.next.val) {
					sortcur = sortcur.next;
				}

				cur.next = sortcur.next;
				sortcur.next = cur;
			}
			cur = next;
		}
		return head;
	}

	public static void main(String[] args) {
		InsertionSortList test = new InsertionSortList();
		ListNode list = new ListNode(5);
		ListNode l = list;
		l.next = new ListNode(4);
		l = l.next;
		l.next = new ListNode(10);
		l = l.next;
		l.next = new ListNode(1);
		l = l.next;
		l.next = new ListNode(7);
		l = l.next;
		l.next = new ListNode(90);
		l = l.next;
		l.next = new ListNode(3);
		l = l.next;
		l.next = new ListNode(8);
		l = l.next;
		l = test.insertionSortList(list);
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
}
