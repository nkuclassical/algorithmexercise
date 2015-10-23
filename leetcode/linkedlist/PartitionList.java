package linkedlist;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode newhead = new ListNode(-1);
		newhead.next = head;
		head = newhead;
		ListNode larger = head.next, smaller = head.next;
		ListNode temp = head;
		while (larger != null && larger.val < x) {
			temp = larger;
			larger = larger.next;
		}
		smaller = temp;
		ListNode cur = temp;
		while (cur.next != null) {
			if (cur.next.val < x) {
				ListNode smallnext = smaller.next;
				ListNode largenext = cur.next.next;
				smaller.next = cur.next;
				smaller = smaller.next;
				smaller.next = smallnext;
				cur.next = largenext;
			} else {
				cur = cur.next;
			}
		}
		return head.next;
	}

	// [-51,-66,18,32,-67,56,4,-61,47,57,14,94,-56,50,-7,-58,-11,60,-99,-11,89,7,-83,97,20,-20,26,-77,-33,
	// 77,-81,16,64,37,-51,97,-54,5,-64,45,-38,3,-9,-41,-47,84,-47,-5,45,-46,84,-14,13,-98,-16,-67,-66,62,
	// -43,1,-9,-24,70,-45,-87,71,-48,-89,-24,-59,56,-10,-4,-52,49,1,-68,-97,96,29,-91,81,-84,23,35,0,56,
	// 21,-86,-87,75,5,-59,45,61,-45,-32,65,-82,44,58,75,-66]
	// -36
	public static void main(String[] args) {
		PartitionList test = new PartitionList();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		// ListNode c=new ListNode(18);
		// ListNode d=new ListNode(32);
		// ListNode e=new ListNode(-67);
		// ListNode f=new ListNode(56);
		// ListNode g=new ListNode(4);
		// ListNode h=new ListNode(-61);
		a.next = b;
		// b.next=c;
		// c.next=d;
		// d.next=e;
		// e.next=f;
		// f.next=g;
		// g.next=h;
		ListNode result = test.partition(a, 2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
