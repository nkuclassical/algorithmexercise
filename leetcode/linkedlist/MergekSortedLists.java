package linkedlist;

import arraylist.ListNode;

public class MergekSortedLists {
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(0);
		ListNode cur = ret;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if (l1 != null) {
			cur.next = l1;
		}

		if (l2 != null) {
			cur.next = l2;
		}
		return ret.next;
	}

	public ListNode divide(ListNode[] lists, int start, int end) {
		if(end<start)return null;
        else if (start == end)
			return lists[start];
		else if (start == end - 1)
			return merge(lists[start], lists[end]);
		else {
			int mid = (start + end) / 2;
			ListNode l1 = divide(lists, start, mid);
			ListNode l2 = divide(lists, mid + 1, end);
			return merge(l1, l2);
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		ListNode l1 = lists[0];
		return divide(lists, 0, lists.length - 1);
	}

	public static void main(String[] args) {
		MergekSortedLists test = new MergekSortedLists();
		ListNode[] lists = new ListNode[2];
		lists[0] = null;
		lists[1] = new ListNode(1);
		ListNode result = test.mergeKLists(lists);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
